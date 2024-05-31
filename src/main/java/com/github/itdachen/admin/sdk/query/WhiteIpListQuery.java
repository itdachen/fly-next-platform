package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 菜单白名单 查询参数
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:38
 */
public class WhiteIpListQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

            /** 应用ID/appID */
            private String appId;

            /** 类型: menu-菜单;element-按钮 */
            private String ipType;

            /** 菜单ID */
            private String menuId;

            /** 菜单名称 */
            private String menuTitle;

            /** 按钮ID */
            private String elementId;

            /** 按钮名称 */
            private String elementTitle;

            /** 白名单类型 */
            private String typeId;

            /** 类型名: 固定IP/范围IP */
            private String typeTitle;

            /** 固定IP */
            private String hostIp;

            /** 固定IP的值 */
            private String hostIpValue;

            /** 起始IP */
            private String startIp;

            /** 起始IP的值 */
            private String startIpValue;

            /** 结束IP */
            private String endIp;

            /** 结束IP的值 */
            private String endIpValue;

            /** 是否展示/有效标志: Y-有效;N-无效 */
            private String validFlag;




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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("page", getPage())
        .append("limit", getLimit())
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
                .toString();
    }

}
