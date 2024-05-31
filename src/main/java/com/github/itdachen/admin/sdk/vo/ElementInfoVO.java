package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 认证资源信息(按钮信息) VO
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
public class ElementInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 资源ID
     */
    private String id;

    /**
     * 应用ID/appID
     */
    private String appId;

    /**
     * 菜单ID
     */
    private String menuId;

    /**
     * 菜单名称
     */
    private String menuTitle;

    /**
     * 标题
     */
    private String title;

    /**
     * 认证编码
     */
    private String authCode;

    /**
     * 类型: button,uri
     */
    private String type;

    /**
     * 页面访问地址
     */
    private String pageUri;

    /**
     * 接口请求地址
     */
    private String apiUri;

    /**
     * API请求类型: POST/GET/PUT/DELETE
     */
    private String httpMethod;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 第三方平台标识
     */
    private String thirdParty;

    /**
     * 第三方平台名称
     */
    private String thirdTitle;

    /**
     * 第三方基础访问地址, 例如: http://www.baidu.com
     */
    private String thirdUri;

    /**
     * 最终访问地址, 根据第三方平台信息拼接
     */
    private String askUri;

    /**
     * 是否展示/有效标志: Y-有效;N-无效
     */
    private String validFlag;

    /**
     * 是否需要授权: Y-需要;N-不需要
     */
    private String hasAuth;

    /**
     * 是否需要IP授权: Y-需要;N-不需要
     */
    private String hasIp;

    /**
     * 备注
     */
    private String remarks;


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
                .toString();
    }

}
