package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.sdk.constants.AppClientConstant;
import com.github.itdachen.admin.convert.IUserInfoConvert;
import com.github.itdachen.admin.entity.SetUserPassword;
import com.github.itdachen.admin.entity.UserInfo;
import com.github.itdachen.admin.entity.UserLogin;
import com.github.itdachen.admin.mapper.IUserInfoMapper;
import com.github.itdachen.admin.mapper.IUserLoginMapper;
import com.github.itdachen.admin.sdk.dto.UserInfoDto;
import com.github.itdachen.admin.sdk.query.UserInfoQuery;
import com.github.itdachen.admin.sdk.vo.UserInfoVo;
import com.github.itdachen.admin.sdk.vo.UserLoginVo;
import com.github.itdachen.admin.service.IUserInfoService;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.UserTypeConstant;
import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.constants.UserStatusConstant;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户信息 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Service
public class UserInfoServiceImpl extends BizServiceImpl<IUserInfoMapper, IUserInfoConvert, UserInfo, UserInfoDto, UserInfoVo, UserInfoQuery, String> implements IUserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    private final PasswordEncoder passwordEncoder;
    private final IUserLoginMapper userLoginMapper;


    public UserInfoServiceImpl(PasswordEncoder passwordEncoder,
                               IUserLoginMapper userLoginMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userLoginMapper = userLoginMapper;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param params params
     * @return com.github.itdachen.framework.core.response.TableData<com.github.itdachen.admin.sdk.vo.userInfoVo>
     */
    @Override
    public TableData<UserInfoVo> page(UserInfoQuery params) throws Exception {
        if ("ROOT".equals(params.getDepartId())) {
            params.setDepartId("660312611032023041");
        }
        Page<UserInfoVo> page = PageHelper.startPage(params.getPage(), params.getLimit());
        List<UserInfoVo> list = bizMapper.page(params);
        return new TableData<UserInfoVo>(page.getTotal(), list);
    }


    /***
     * 新增
     *
     * @author 王大宸
     * @date 2022/8/27 18:55
     * @param userInfoDto userInfoDto
     * @return com.itdachen.admin.entity.User
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoVo saveInfo(UserInfoDto userInfoDto) throws Exception {
        if (StringUtils.isEmpty(userInfoDto.getUsername())) {
            throw new BizException("登录账号不能为空!");
        }
        if (StringUtils.isEmpty(userInfoDto.getPassword())) {
            throw new BizException("密码不能为空!");
        }
        UserInfoVo one = bizMapper.findUserByUsername(userInfoDto.getUsername());
        if (null != one) {
            throw new BizException("登录账号 " + userInfoDto.getUsername() + " 已经存在!");
        }

        UserInfo userInfo = bizConvert.toJavaObject(userInfoDto);

        userInfo.setStatus(UserStatusConstant.IS_OK);
        userInfo.setType(UserTypeConstant.MEMBER);
        EntityUtils.setCreatAndUpdateInfo(userInfo);

        userLoginMapper.saveUserLogin(UserLogin.builder()
                .id(userInfo.getId())
                .userId(userInfo.getId())
                .tenantId(userInfo.getTenantId())
                .appId(AppClientConstant.WEB_APP)
                .username(userInfo.getUsername())
                .password(passwordEncoder.encode(userInfo.getPassword()))
                .status(userInfo.getStatus())
                .userType(userInfo.getType())
                .nickName(userInfo.getName())
                .avatar(userInfo.getAvatar())
                .delFlag(YesOrNotConstant.NOT)
                .canDel(YesOrNotConstant.YES)
                .expireTime(LocalDateTime.now().minusDays(180))
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build());

        bizMapper.insertSelective(userInfo);
        return bizConvert.toJavaObjectVo(userInfo);
    }


    /***
     * 更新
     *
     * @author 王大宸
     * @date 2022/8/27 18:58
     * @param userInfoDto userInfoDto
     * @return com.itdachen.admin.entity.User
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoVo updateInfo(UserInfoDto userInfoDto) throws Exception {
        UserInfo user = bizMapper.selectByPrimaryKey(userInfoDto.getId());
        if (UserStatusConstant.IS_LOCKED.equals(userInfoDto.getStatus())) {
            if (UserTypeConstant.SUPER_ADMINISTRATOR_USERNAME.equals(user.getUsername())
                    || UserTypeConstant.SUPER_ADMINISTRATOR.equals(user.getType())) {
                throw new BizException(UserTypeConstant.SUPER_ADMINISTRATOR_USERNAME + " 账号不能被冻结");
            }
            userInfoDto.setUsername(user.getUsername());

            userLoginMapper.updateUserLogin(UserLogin.builder()
                    .id(user.getId())
                    .status(user.getStatus())
                    .updateTime(LocalDateTime.now())
                    .build());
        }

        return super.updateInfo(userInfoDto);
    }

    /***
     * 删除
     *
     * @author 王大宸
     * @date 2022/8/27 18:59
     * @param id id
     * @return int
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(String id) throws Exception {
        UserInfo user = bizMapper.selectByPrimaryKey(id);
        if (null == user) {
            return 1;
        }
        if (UserTypeConstant.SUPER_ADMINISTRATOR_USERNAME.equals(user.getUsername())
                || UserTypeConstant.SUPER_ADMINISTRATOR.equals(user.getType())
                || UserTypeConstant.TENANT_ADMINISTRATOR.equals(user.getType())) {
            throw new BizException("管理员账号不能被删除");
        }
        userLoginMapper.updateUserLogin(UserLogin.builder()
                .id(user.getId())
                .delFlag(YesOrNotConstant.YES)
                .updateTime(LocalDateTime.now())
                .build());
        return bizMapper.deleteByPrimaryKey(id);
    }

    /***
     * 修改用户状态
     *
     * @author 王大宸
     * @date 2022/8/27 19:01
     * @param id id
     * @param status status
     * @return com.itdachen.admin.entity.User
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfo updateUserStatus(String id, Boolean status) throws BizException {
        UserInfo user = new UserInfo();
        user.setId(id);
        user.setStatus(UserStatusConstant.IS_LOCKED);
        if (status) {
            user.setStatus(UserStatusConstant.IS_OK);
        }
        EntityUtils.setUpdatedInfo(user);
        bizMapper.updateByPrimaryKeySelective(user);

        userLoginMapper.updateUserLogin(UserLogin.builder()
                .id(id)
                .status(user.getStatus())
                .updateTime(LocalDateTime.now())
                .build());

        return user;
    }

    /***
     * 修改密码
     *
     * @author 王大宸
     * @date 2022/9/7 16:52
     * @param userPassword userPassword
     * @return com.itdachen.admin.sdk.vo.UserVo
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void password(SetUserPassword userPassword) throws BizException {
        if (!userPassword.getPassword().equals(userPassword.getRepassword())) {
            throw new BizException("输入的两次新密码不一致!");
        }

        UserLoginVo userLoginVo = userLoginMapper.getById(BizContextHandler.getUserId());
        boolean matches = passwordEncoder.matches(userPassword.getOldPassword(), userLoginVo.getPassword());
        if (!matches) {
            throw new BizException("当前使用密码错误!");
        }
        userLoginMapper.updateUserLogin(UserLogin.builder()
                .id(userLoginVo.getId())
                .password(passwordEncoder.encode(userPassword.getPassword()))
                .updateTime(LocalDateTime.now())
                .build());
    }


}
