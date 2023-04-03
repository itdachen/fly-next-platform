package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;



/**
 * 权限下发
 *
 * @author 王大宸
 * @date 2022-08-24 23:30:59
 */
@Table(name = "sys_perms_auth" )
public class PermsAuth implements Serializable{
    private static final long serialVersionUID=1L;

    /** 主键id */
    @Id
    @Column(name = "id" )
    private String id;

    /** 用户id */
    @Column(name = "user_id" )
    private String userId;

    /** 菜单id */
    @Column(name = "menu_id" )
    private String menuId;


    public void setId(String id) {
            this.id = id;
    }

    public String getId() {
            return id;
    }

    public void setUserId(String userId) {
            this.userId = userId;
    }

    public String getUserId() {
            return userId;
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
            .append("userId", getUserId())
            .append("menuId", getMenuId())
        .toString();
    }


}
