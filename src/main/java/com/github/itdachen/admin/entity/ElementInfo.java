package com.github.itdachen.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 认证资源信息(按钮信息)
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
@Table(name = "ta_fly_route_element_info")
public class ElementInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 资源ID
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
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 认证编码
     */
    @Column(name = "auth_code")
    private String authCode;

    /**
     * 类型: button,uri
     */
    @Column(name = "type")
    private String type;

    /**
     * 页面访问地址
     */
    @Column(name = "page_uri")
    private String pageUri;

    /**
     * 接口请求地址
     */
    @Column(name = "api_uri")
    private String apiUri;

    /**
     * API请求类型: POST/GET/PUT/DELETE
     */
    @Column(name = "http_method")
    private String httpMethod;

    /**
     * 排序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 第三方平台标识
     */
    @Column(name = "third_party")
    private String thirdParty;

    /**
     * 第三方平台名称
     */
    @Column(name = "third_title")
    private String thirdTitle;

    /**
     * 第三方基础访问地址, 例如: http://www.baidu.com
     */
    @Column(name = "third_uri")
    private String thirdUri;

    /**
     * 最终访问地址, 根据第三方平台信息拼接
     */
    @Column(name = "ask_uri")
    private String askUri;

    /**
     * 是否展示/有效标志: Y-有效;N-无效
     */
    @Column(name = "valid_flag")
    private String validFlag;

    /**
     * 是否需要授权: Y-需要;N-不需要
     */
    @Column(name = "has_auth")
    private String hasAuth;

    /**
     * 是否需要IP授权: Y-需要;N-不需要
     */
    @Column(name = "has_ip")
    private String hasIp;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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

    public void setPageUri(String pageUri) {
        this.pageUri = pageUri;
    }

    public String getPageUri() {
        return pageUri;
    }

    public void setApiUri(String apiUri) {
        this.apiUri = apiUri;
    }

    public String getApiUri() {
        return apiUri;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() {
        return orderNum;
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

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getValidFlag() {
        return validFlag;
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
                .append("menuId", getMenuId())
                .append("menuTitle", getMenuTitle())
                .append("title", getTitle())
                .append("authCode", getAuthCode())
                .append("type", getType())
                .append("pageUri", getPageUri())
                .append("apiUri", getApiUri())
                .append("httpMethod", getHttpMethod())
                .append("orderNum", getOrderNum())
                .append("thirdParty", getThirdParty())
                .append("thirdTitle", getThirdTitle())
                .append("thirdUri", getThirdUri())
                .append("askUri", getAskUri())
                .append("validFlag", getValidFlag())
                .append("hasAuth", getHasAuth())
                .append("hasIp", getHasIp())
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
