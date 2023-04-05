package com.github.itdachen.admin.service.impl;

import com.github.itdachen.admin.entity.SetUserPassword;
import com.github.itdachen.framework.context.BizContextHandler;
import com.github.itdachen.framework.context.constants.UserTypeConstant;
import com.github.itdachen.framework.context.exception.BizException;
import com.github.itdachen.framework.core.constants.UserStatusConstant;
import com.github.itdachen.framework.core.utils.StringUtils;
import com.github.itdachen.framework.webmvc.entity.EntityUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.itdachen.admin.entity.UserInfo;
import com.github.itdachen.admin.sdk.query.UserInfoQuery;
import com.github.itdachen.admin.sdk.vo.UserInfoVo;
import com.github.itdachen.framework.core.response.TableData;
import com.github.itdachen.framework.webmvc.service.impl.BizServiceImpl;
import com.github.itdachen.admin.mapper.IUserInfoMapper;
import com.github.itdachen.admin.service.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息 业务实现
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:46
 */
@Service
public class UserInfoServiceImpl extends BizServiceImpl<IUserInfoMapper, UserInfo, UserInfoVo, UserInfoQuery, String> implements IUserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    private final PasswordEncoder passwordEncoder;

    public UserInfoServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /***
     * 分页
     *
     * @author 王大宸
     * @date 2023-04-04 21:44:46
     * @param params params
     * @return cn.edu.hubu.common.core.response.TableData<com.github.itdachen.admin.sdk.vo.userInfoVo>
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
     * @param entity entity
     * @return com.itdachen.admin.entity.User
     */
    @Override
    public UserInfo save(UserInfo entity) throws Exception {
        if (StringUtils.isEmpty(entity.getUsername())) {
            throw new BizException("登录账号不能为空!");
        }
        if (StringUtils.isEmpty(entity.getPassword())) {
            throw new BizException("密码不能为空!");
        }
        UserInfoVo one = bizMapper.findUserByUsername(entity.getUsername());
        if (null != one) {
            throw new BizException("登录账号 " + entity.getUsername() + " 已经存在!");
        }
        entity.setStatus(UserStatusConstant.IS_OK);
        entity.setType(UserTypeConstant.MEMBER);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return super.save(entity);
    }


    /***
     * 更新
     *
     * @author 王大宸
     * @date 2022/8/27 18:58
     * @param entity entity
     * @return com.itdachen.admin.entity.User
     */
    @Override
    public UserInfo update(UserInfo entity) throws Exception {
        UserInfo user = bizMapper.selectByPrimaryKey(entity.getId());
        if (UserTypeConstant.SUPER_ADMINISTRATOR_USERNAME.equals(user.getUsername())
                || UserTypeConstant.SUPER_ADMINISTRATOR.equals(user.getType())) {
            if (UserStatusConstant.IS_LOCKED.equals(entity.getStatus())) {
                throw new BizException(UserTypeConstant.SUPER_ADMINISTRATOR_USERNAME + " 账号不能被冻结");
            }
            entity.setUsername(user.getUsername());
        }
        return super.update(entity);
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
    public int remove(String id) throws Exception {
        UserInfo user = bizMapper.selectByPrimaryKey(id);
        if (null == user) {
            return 1;
        }
        if (UserTypeConstant.SUPER_ADMINISTRATOR_USERNAME.equals(user.getUsername())
                || UserTypeConstant.SUPER_ADMINISTRATOR.equals(user.getType())
                || UserTypeConstant.TENANT_ADMINISTRATOR.equals(user.getType())) {
            throw new BizException("管理员账号不能被删除");
        }
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
    public UserInfo updateUserStatus(String id, Boolean status) throws BizException {
        UserInfo user = new UserInfo();
        user.setId(id);
        user.setStatus(UserStatusConstant.IS_LOCKED);
        if (status) {
            user.setStatus(UserStatusConstant.IS_OK);
        }
        EntityUtils.setUpdatedInfo(user);
        bizMapper.updateByPrimaryKeySelective(user);
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
    public UserInfoVo password(SetUserPassword userPassword) throws BizException {
        if (!userPassword.getPassword().equals(userPassword.getRepassword())) {
            throw new BizException("输入的两次新密码不一致!");
        }
        UserInfo user = bizMapper.selectByPrimaryKey(BizContextHandler.getUserId());
        boolean matches = passwordEncoder.matches(userPassword.getOldPassword(), user.getPassword());
        if (!matches) {
            throw new BizException("当前使用密码错误!");
        }
        user.setPassword(passwordEncoder.encode(userPassword.getPassword()));
        bizMapper.updateByPrimaryKeySelective(user);
        return null;
    }


}
