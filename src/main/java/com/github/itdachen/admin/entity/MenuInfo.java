package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
    import java.time.LocalDateTime;



/**
 * 菜单信息
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
@Table(name = "ta_fly_route_menu_info")
public class MenuInfo implements Serializable{
private static final long serialVersionUID=1L;

    /** 菜单ID */
    @Id
    @Column(name = "id")
    private String id;

    /** 应用ID/appId */
    @Column(name = "app_id")
    private String appId;

    /** 上级ID */
    @Column(name = "parent_id")
    private String parentId;

    /** 上级菜单 */
    @Column(name = "parent_title")
    private String parentTitle;

    /** 认证编码 */
    @Column(name = "auth_code")
    private String authCode;

    /** 类型:dirt-目录;menu-菜单;uri-外链;third-第三方平台 */
    @Column(name = "type")
    private String type;

    /** 菜单标题 */
    @Column(name = "title")
    private String title;

    /** 访问地址 */
    @Column(name = "path")
    private String path;

    /** 图标 */
    @Column(name = "lay_icon")
    private String layIcon;

    /** 排序 */
    @Column(name = "order_num")
    private Integer orderNum;

    /** 是否展示/有效标志: Y-有效;N-无效 */
    @Column(name = "valid_flag")
    private String validFlag;

    /** 菜单打开方式 */
    @Column(name = "open_type")
    private String openType;

    /** 是否需要授权: Y-需要;N-不需要 */
    @Column(name = "has_auth")
    private String hasAuth;

    /** 是否需要白名单IP: Y-需要;N-不需要 */
    @Column(name = "has_ip")
    private String hasIp;

    /** 第三方平台标识 */
    @Column(name = "third_party")
    private String thirdParty;

    /** 第三方平台名称 */
    @Column(name = "third_title")
    private String thirdTitle;

    /** 第三方基础访问地址, 例如: http://www.baidu.com */
    @Column(name = "third_uri")
    private String thirdUri;

    /** 最终访问地址, 根据第三方平台信息拼接 */
    @Column(name = "ask_uri")
    private String askUri;

    /** 组件名称 */
    @Column(name = "component_name")
    private String componentName;

    /** 备注 */
    @Column(name = "remarks")
    private String remarks;

    /** 创建时间 */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /** 创建人 */
    @Column(name = "create_user")
    private String createUser;

    /** 创建人id */
    @Column(name = "create_user_id")
    private String createUserId;

    /** 更新时间 */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /** 更新人 */
    @Column(name = "update_user")
    private String updateUser;

    /** 更新人id */
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

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentTitle(String parentTitle) {
                this.parentTitle = parentTitle;
            }

            public String getParentTitle() {
                return parentTitle;
            }

            public void setAuthCode(String authCode) {
                this.authCode = authCode;
            }

            public String getAuthCode() {
                return authCode;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getType() {
                return type;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitle() {
                return title;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public String getPath() {
                return path;
            }

            public void setLayIcon(String layIcon) {
                this.layIcon = layIcon;
            }

            public String getLayIcon() {
                return layIcon;
            }

            public void setOrderNum(Integer orderNum) {
                this.orderNum = orderNum;
            }

            public Integer getOrderNum() {
                return orderNum;
            }

            public void setValidFlag(String validFlag) {
                this.validFlag = validFlag;
            }

            public String getValidFlag() {
                return validFlag;
            }

            public void setOpenType(String openType) {
                this.openType = openType;
            }

            public String getOpenType() {
                return openType;
            }

            public void setHasAuth(String hasAuth) {
                this.hasAuth = hasAuth;
            }

            public String getHasAuth() {
                return hasAuth;
            }

            public void setHasIp(String hasIp) {
                this.hasIp = hasIp;
            }

            public String getHasIp() {
                return hasIp;
            }

            public void setThirdParty(String thirdParty) {
                this.thirdParty = thirdParty;
            }

            public String getThirdParty() {
                return thirdParty;
            }

            public void setThirdTitle(String thirdTitle) {
                this.thirdTitle = thirdTitle;
            }

            public String getThirdTitle() {
                return thirdTitle;
            }

            public void setThirdUri(String thirdUri) {
                this.thirdUri = thirdUri;
            }

            public String getThirdUri() {
                return thirdUri;
            }

            public void setAskUri(String askUri) {
                this.askUri = askUri;
            }

            public String getAskUri() {
                return askUri;
            }

            public void setComponentName(String componentName) {
                this.componentName = componentName;
            }

            public String getComponentName() {
                return componentName;
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
                    .append("parentId", getParentId())
                    .append("parentTitle", getParentTitle())
                    .append("authCode", getAuthCode())
                    .append("type", getType())
                    .append("title", getTitle())
                    .append("path", getPath())
                    .append("layIcon", getLayIcon())
                    .append("orderNum", getOrderNum())
                    .append("validFlag", getValidFlag())
                    .append("openType", getOpenType())
                    .append("hasAuth", getHasAuth())
                    .append("hasIp", getHasIp())
                    .append("thirdParty", getThirdParty())
                    .append("thirdTitle", getThirdTitle())
                    .append("thirdUri", getThirdUri())
                    .append("askUri", getAskUri())
                    .append("componentName", getComponentName())
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
