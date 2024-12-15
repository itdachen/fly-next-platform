package com.github.itdachen.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 菜单白名单
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:38
 */
@Table(name = "ta_fly_route_white_ip_list")
public class WhiteIpList implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键唯一标识
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 应用ID/appID
     */
    @Column(name = "app_id")
    private String appId;

    /**
     * 类型: menu-菜单;element-按钮
     */
    @Column(name = "ip_type")
    private String ipType;

    /**
     * 菜单ID
     */
    @Column(name = "menu_id")
    private String menuId;

    /**
     * 菜单名称
     */
    @Column(name = "menu_title")
    private String menuTitle;

    /**
     * 按钮ID
     */
    @Column(name = "element_id")
    private String elementId;

    /**
     * 按钮名称
     */
    @Column(name = "element_title")
    private String elementTitle;

    /**
     * 白名单类型
     */
    @Column(name = "type_id")
    private String typeId;

    /**
     * 类型名: 固定IP/范围IP
     */
    @Column(name = "type_title")
    private String typeTitle;

    /**
     * 固定IP
     */
    @Column(name = "host_ip")
    private String hostIp;

    /**
     * 固定IP的值
     */
    @Column(name = "host_ip_value")
    private String hostIpValue;

    /**
     * 起始IP
     */
    @Column(name = "start_ip")
    private String startIp;

    /**
     * 起始IP的值
     */
    @Column(name = "start_ip_value")
    private String startIpValue;

    /**
     * 结束IP
     */
    @Column(name = "end_ip")
    private String endIp;

    /**
     * 结束IP的值
     */
    @Column(name = "end_ip_value")
    private String endIpValue;

    /**
     * 是否展示/有效标志: Y-有效;N-无效
     */
    @Column(name = "valid_flag")
    private String validFlag;

    /**
     * 备注
     */
    @Column(name = "remarks")
    private String remarks;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    private String createUserId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 更新人id
     */
    @Column(name = "update_user_id")
    private String updateUserId;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppId() {
        return appId;
    }

    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    public String getIpType() {
        return ipType;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementTitle(String elementTitle) {
        this.elementTitle = elementTitle;
    }

    public String getElementTitle() {
        return elementTitle;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIpValue(String hostIpValue) {
        this.hostIpValue = hostIpValue;
    }

    public String getHostIpValue() {
        return hostIpValue;
    }

    public void setStartIp(String startIp) {
        this.startIp = startIp;
    }

    public String getStartIp() {
        return startIp;
    }

    public void setStartIpValue(String startIpValue) {
        this.startIpValue = startIpValue;
    }

    public String getStartIpValue() {
        return startIpValue;
    }

    public void setEndIp(String endIp) {
        this.endIp = endIp;
    }

    public String getEndIp() {
        return endIp;
    }

    public void setEndIpValue(String endIpValue) {
        this.endIpValue = endIpValue;
    }

    public String getEndIpValue() {
        return endIpValue;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("appId", getAppId())
                .append("ipType", getIpType())
                .append("menuId", getMenuId())
                .append("menuTitle", getMenuTitle())
                .append("elementId", getElementId())
                .append("elementTitle", getElementTitle())
                .append("typeId", getTypeId())
                .append("typeTitle", getTypeTitle())
                .append("hostIp", getHostIp())
                .append("hostIpValue", getHostIpValue())
                .append("startIp", getStartIp())
                .append("startIpValue", getStartIpValue())
                .append("endIp", getEndIp())
                .append("endIpValue", getEndIpValue())
                .append("validFlag", getValidFlag())
                .append("remarks", getRemarks())
                .append("createTime", getCreateTime())
                .append("createUser", getCreateUser())
                .append("createUserId", getCreateUserId())
                .append("updateTime", getUpdateTime())
                .append("updateUser", getUpdateUser())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }


}
