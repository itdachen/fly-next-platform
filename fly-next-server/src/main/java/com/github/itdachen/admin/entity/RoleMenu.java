package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;



/**
 * 菜单角色
 *
 * @author 王大宸
 * @date 2022-08-24 23:30:59
 */
@Table(name = "sys_role_menu" )
public class RoleMenu implements Serializable{
    private static final long serialVersionUID=1L;

    /** 数据唯一标识 */
    @Id
    @Column(name = "id" )
    private String id;

    /** 用户id */
    @Column(name = "role_id" )
    private String roleId;

    /** 菜单id */
    @Column(name = "menu_id" )
    private String menuId;


    public void setId(String id) {
            this.id = id;
    }

    public String getId() {
            return id;
    }

    public void setRoleId(String roleId) {
            this.roleId = roleId;
    }

    public String getRoleId() {
            return roleId;
    }

    public void setMenuId(String menuId) {
            this.menuId = menuId;
    }

    public String getMenuId() {
            return menuId;
    }


    @Override
    public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("roleId", getRoleId())
            .append("menuId", getMenuId())
        .toString();
    }


}
