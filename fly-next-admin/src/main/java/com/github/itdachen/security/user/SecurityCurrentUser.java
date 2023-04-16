package com.github.itdachen.security.user;

import com.github.itdachen.framework.context.permission.PermissionInfo;
import com.github.itdachen.framework.context.userdetails.CurrentUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Set;

/**
 * Description:
 * Created by 王大宸 on 2023/04/15 21:25
 * Created with IntelliJ IDEA.
 */
public class SecurityCurrentUser extends CurrentUserDetails {

    /**
     * 可以访问的 url
     */
    private Set<PermissionInfo> urls;

    /**
     * 拥有的权限标识
     */
    private Set<String> perms;

    /**
     * 拥有的角色
     */
    private Collection<GrantedAuthority> authorities;

    public Set<PermissionInfo> getUrls() {
        return urls;
    }

    public void setUrls(Set<PermissionInfo> urls) {
        this.urls = urls;
    }

    public Set<String> getPerms() {
        return perms;
    }

    public void setPerms(Set<String> perms) {
        this.perms = perms;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

}
