package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 菜单信息 查询参数
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:39
 */
public class MenuInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 应用ID/appId */
            private String appId;

            /** 上级ID */
            private String parentId;

            /** 上级菜单 */
            private String parentTitle;

            /** 认证编码 */
            private String authCode;

            /** 类型:dirt-目录;menu-菜单;uri-外链;third-第三方平台 */
            private String type;

            /** 菜单标题 */
            private String title;

            /** 访问地址 */
            private String path;

            /** 图标 */
            private String layIcon;

            /** 排序 */
            private Integer orderNum;

            /** 是否展示/有效标志: Y-有效;N-无效 */
            private String validFlag;

            /** 菜单打开方式 */
            private String openType;

            /** 是否需要授权: Y-需要;N-不需要 */
            private String hasAuth;

            /** 是否需要白名单IP: Y-需要;N-不需要 */
            private String hasIp;

            /** 第三方平台标识 */
            private String thirdParty;

            /** 第三方平台名称 */
            private String thirdTitle;

            /** 第三方基础访问地址, 例如: http://www.baidu.com */
            private String thirdUri;

            /** 最终访问地址, 根据第三方平台信息拼接 */
            private String askUri;

            /** 组件名称 */
            private String componentName;




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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("page", getPage())
        .append("limit", getLimit())
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
                .toString();
    }

}
