package com.github.itdachen.admin.sdk.dto;

import com.github.itdachen.framework.context.constants.YesOrNotConstant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;

/**
 * 菜单信息 DTO
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
public class MenuInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    private String id;

    /**
     * 应用ID/appId
     */
  //  @NotBlank(message = "应用ID/appId不能为空")
    private String appId;

    /**
     * 上级ID
     */
   // @NotBlank(message = "上级ID不能为空")
    private String parentId;

    /**
     * 上级菜单
     */
   // @NotBlank(message = "上级菜单不能为空")
    private String parentTitle;

    /**
     * 认证编码
     */
    @NotBlank(message = "认证编码不能为空")
    private String authCode;

    /**
     * 类型:dirt-目录;menu-菜单;uri-外链;third-第三方平台
     */
   // @NotBlank(message = "类型:dirt-目录;menu-菜单;uri-外链;third-第三方平台不能为空")
    private String type;

    /**
     * 菜单标题
     */
   // @NotBlank(message = "菜单标题不能为空")
    private String title;

    /**
     * 访问地址
     */
    @NotBlank(message = "访问地址不能为空")
    private String path;

    /**
     * 图标
     */
   // @NotBlank(message = "图标不能为空")
    private String layIcon;

    /**
     * 排序
     */
   // @NotNull(message = "排序不能为空")
    private Integer orderNum;

    /**
     * 是否展示/有效标志: Y-有效;N-无效
     */
    @NotBlank(message = "是否展示/有效标志: Y-有效;N-无效不能为空")
    private String validFlag;

    /**
     * 菜单打开方式
     */
    @NotBlank(message = "菜单打开方式不能为空")
    private String openType;

    /**
     * 是否需要授权: Y-需要;N-不需要
     */
    @NotBlank(message = "是否需要授权: Y-需要;N-不需要不能为空")
    private String hasAuth;

    /**
     * 是否需要白名单IP: Y-需要;N-不需要
     */
 //   @NotBlank(message = "是否需要白名单IP: Y-需要;N-不需要不能为空")
    private String hasIp = YesOrNotConstant.N;

    /**
     * 第三方平台标识
     */
  //  @NotBlank(message = "第三方平台标识不能为空")
    private String thirdParty;

    /**
     * 第三方平台名称
     */
  //  @NotBlank(message = "第三方平台名称不能为空")
    private String thirdTitle;

    /**
     * 第三方基础访问地址, 例如: http://www.baidu.com
     */
   // @NotBlank(message = "第三方基础访问地址, 例如: http://www.baidu.com不能为空")
    private String thirdUri;

    /**
     * 最终访问地址, 根据第三方平台信息拼接
     */
   // @NotBlank(message = "最终访问地址, 根据第三方平台信息拼接不能为空")
    private String askUri;

    /**
     * 组件名称
     */
  //  @NotBlank(message = "组件名称不能为空")
    private String componentName;

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
                .toString();
    }

}
