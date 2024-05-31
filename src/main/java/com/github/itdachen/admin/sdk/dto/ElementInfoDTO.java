package com.github.itdachen.admin.sdk.dto;

import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;

/**
 * 认证资源信息(按钮信息) DTO
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
public class ElementInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 资源ID
     */
    private String id;

    /**
     * 应用ID/appID
     */
  //  @NotBlank(message = "应用ID/appID不能为空")
    private String appId;

    /**
     * 菜单ID
     */
  //  @NotBlank(message = "菜单ID不能为空")
    private String menuId;

    /**
     * 菜单名称
     */
   // @NotBlank(message = "菜单名称不能为空")
    private String menuTitle;

    /**
     * 资源名称
     */
    // @NotBlank(message = "菜单名称不能为空")
    private String title;

    /**
     * 认证编码
     */
    @NotBlank(message = "认证编码不能为空")
    private String authCode;

    /**
     * 类型: button,uri
     */
    @NotBlank(message = "类型: button,uri不能为空")
    private String type;

    /**
     * 页面访问地址
     */
    @NotBlank(message = "页面访问地址不能为空")
    private String pageUri;

    /**
     * 接口请求地址
     */
    @NotBlank(message = "接口请求地址不能为空")
    private String apiUri;

    /**
     * API请求类型: POST/GET/PUT/DELETE
     */
    @NotBlank(message = "API请求类型: POST/GET/PUT/DELETE不能为空")
    private String httpMethod;

    /**
     * 排序
     */
  //  @NotBlank(message = "排序不能为空")
    private Integer orderNum;

    /**
     * 第三方平台标识
     */
   // @NotBlank(message = "第三方平台标识不能为空")
    private String thirdParty;

    /**
     * 第三方平台名称
     */
   // @NotBlank(message = "第三方平台名称不能为空")
    private String thirdTitle;

    /**
     * 第三方基础访问地址, 例如: http://www.baidu.com
     */
   // @NotBlank(message = "第三方基础访问地址, 例如: http://www.baidu.com不能为空")
    private String thirdUri;

    /**
     * 最终访问地址, 根据第三方平台信息拼接
     */
  //  @NotBlank(message = "最终访问地址, 根据第三方平台信息拼接不能为空")
    private String askUri;

    /**
     * 是否展示/有效标志: Y-有效;N-无效
     */
   // @NotBlank(message = "是否展示/有效标志: Y-有效;N-无效不能为空")
    private String validFlag;

    /**
     * 是否需要授权: Y-需要;N-不需要
     */
    @NotBlank(message = "是否需要授权: Y-需要;N-不需要不能为空")
    private String hasAuth = YesOrNotConstant.Y;

    /**
     * 是否需要IP授权: Y-需要;N-不需要
     */
    @NotBlank(message = "是否需要IP授权: Y-需要;N-不需要不能为空")
    private String hasIp = YesOrNotConstant.N;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
