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
 * @date 2023-04-04 21:44:46
 */
@Table(name = "sys_role_menu")
public class RoleMenu implements Serializable{
private static final long serialVersionUID=1L;

    /** 数据唯一标识 */
    @Id
    @Column(name = "id")
    private String id;

    /** 用户id */
    @Column(name = "role_id")
    private String roleId;

    /** 菜单id */
    @Column(name = "menu_id")
    private String menuId;


public RoleMenu(){}


public RoleMenu(    String id,     String roleId,     String menuId){
            this.id = id;
            this.roleId = roleId;
            this.menuId = menuId;
}

public static RoleMenuBuilder builder(){
        return new RoleMenuBuilder();
        }

public static class RoleMenuBuilder {
        private String id;
        private String roleId;
        private String menuId;

    public RoleMenuBuilder() {
    }

        /* 数据唯一标识 */
        public RoleMenuBuilder id(String id) {
            this.id = id;
            return this;
        }
        /* 用户id */
        public RoleMenuBuilder roleId(String roleId) {
            this.roleId = roleId;
            return this;
        }
        /* 菜单id */
        public RoleMenuBuilder menuId(String menuId) {
            this.menuId = menuId;
            return this;
        }

    public RoleMenu build() {
        return new RoleMenu(            id, 
            roleId, 
            menuId
);
    }

}


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
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                    .append("id", getId())
                    .append("roleId", getRoleId())
                    .append("menuId", getMenuId())
                .toString();
    }


}
