package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.service.impl.manager.LoginInfoEvent;
import com.github.itdachen.auth.entity.LoginInfo;
import com.github.itdachen.auth.mapper.ILoginInfoMapper;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.UserTypeConstant;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.AssertUtils;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.UserInfo;
import com.github.itdachen.admin.sdk.dto.UserInfoDTO;
import com.github.itdachen.admin.sdk.query.UserInfoQuery;
import com.github.itdachen.admin.sdk.vo.UserInfoVO;
import com.github.itdachen.admin.mapper.IUserInfoMapper;
import com.github.itdachen.admin.service.IUserInfoService;
import com.github.itdachen.admin.convert.UserInfoConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户信息 业务实现
 *
 * @author 王大宸
 * @date 2024-04-27 20:42:58
 */
@Service
public class UserInfoServiceImpl extends BizServiceImpl<IUserInfoMapper, UserInfo, UserInfoDTO, UserInfoVO, UserInfoQuery, String> implements IUserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    private static final UserInfoConvert bizConvert = new UserInfoConvert();
    private static final Integer USER_ID_START = 50000;

    private final ILoginInfoMapper loginInfoMapper;
    private final ApplicationEventPublisher eventPublisher;

    public UserInfoServiceImpl(ILoginInfoMapper loginInfoMapper,
                               ApplicationEventPublisher eventPublisher) {
        super(bizConvert);
        this.loginInfoMapper = loginInfoMapper;
        this.eventPublisher = eventPublisher;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2024-04-27 20:42:58
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.userInfoVo>
     */
    @Override
    public TableData<UserInfoVO> page(UserInfoQuery params) throws Exception {
        Page<UserInfoVO> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<UserInfoVO> list = bizMapper.list(params);
        return new TableData<UserInfoVO>(page.getTotal(), list);
    }


    /***
     * 新增
     *
     * @author 王大宸
     * @date 2024/5/8 23:10
     * @param userInfoDTO userInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.UserInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoVO saveInfo(UserInfoDTO userInfoDTO) throws Exception {
        UserInfoVO userInfoByTelephone = bizMapper.findUserInfoByTelephone(userInfoDTO.getTelephone());
        AssertUtils.isTrue(null != userInfoByTelephone, "该手机号码已经存在");


        // 分布式情况下, 添加分布式锁, 获取唯一的用户号/工号
        UserInfo userInfo = bizConvert.toJavaObject(userInfoDTO);
        userInfo.setUserType(UserTypeConstant.INSIDE_USER);
        EntityUtils.setCreatAndUpdateInfo(userInfo);
        Integer userTotal = bizMapper.findUserTotal();
        if (null == userTotal) {
            userTotal = 0;
        }
        userTotal++;
        Integer userId = USER_ID_START + userTotal;
        userInfo.setId(String.valueOf(userId));
        bizMapper.insertSelective(userInfo);

        /**
         * 发布订阅模式的实现
         * 2、发布事件
         */
        LoginInfoEvent event = new LoginInfoEvent(this, userInfo.getId(), userInfo.getNickName(), userInfo.getTelephone());
        eventPublisher.publishEvent(event);

        return bizConvert.toJavaObjectVO(userInfo);
    }


    /***
     * 编辑
     *
     * @author 王大宸
     * @date 2024/5/8 23:10
     * @param userInfoDTO userInfoDTO
     * @return com.github.itdachen.admin.sdk.vo.UserInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoVO updateInfo(UserInfoDTO userInfoDTO) throws Exception {
        UserInfoVO userInfoByTelephone = bizMapper.findUserInfoByTelephone(userInfoDTO.getTelephone());
        if (null != userInfoByTelephone && !userInfoByTelephone.getId().equals(userInfoDTO.getId())) {
            throw new BizException("该手机号码已经存在");
        }
        UserInfo userInfo = bizConvert.toJavaObject(userInfoDTO);
        EntityUtils.setUpdatedInfo(userInfo);
        bizMapper.updateByPrimaryKeySelective(userInfo);

        /* 更新登录账号 */
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setId(userInfo.getId());
        loginInfo.setUsername(userInfo.getTelephone());
        loginInfo.setValidFlag(userInfo.getValidFlag());
        loginInfoMapper.updateByPrimaryKeySelective(loginInfo);

        return bizConvert.toJavaObjectVO(userInfo);
    }

    /***
     * 删除用户信息
     *
     * @author 王大宸
     * @date 2024/5/8 23:47
     * @param id id
     * @return int
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(String id) throws Exception {
        UserInfoVO userInfoVO = bizMapper.selectUserInfoVO(id);
        if (UserTypeConstant.SUPER_ADMINISTRATOR.equals(userInfoVO.getUserType())
                || UserTypeConstant.TENANT_ADMINISTRATOR.equals(userInfoVO.getUserType())) {
            throw new BizException("该用户信息不能删除！");
        }
        loginInfoMapper.deleteByPrimaryKey(id);
        return bizMapper.deleteByPrimaryKey(id);
    }

    /***
     * 有效标志
     *
     * @author 王大宸
     * @date 2024/5/8 23:36
     * @param id id
     * @param checked checked
     * @return void
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void validFlagChecked(String id, Boolean checked) throws Exception {
        UserInfo info = new UserInfo();
        info.setId(id);
        info.setValidFlag(checked ? YesOrNotConstant.Y : YesOrNotConstant.N);
        bizMapper.updateByPrimaryKeySelective(info);

        /* 更新登录账号状态 */
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setId(id);
        loginInfo.setValidFlag(info.getValidFlag());
        loginInfoMapper.updateByPrimaryKeySelective(loginInfo);
    }

    /***
     * 根据电话号码查询用户信息
     *
     * @author 王大宸
     * @date 2024/5/9 23:15
     * @param telephone telephone
     * @return com.github.itdachen.admin.sdk.vo.UserInfoVO
     */
    @Override
    public UserInfoVO findUserInfoByTelephone(String telephone) throws Exception {
        return bizMapper.findTenantUserInfoByTelephone(telephone, BizContextHandler.getTenantId());
    }

}
