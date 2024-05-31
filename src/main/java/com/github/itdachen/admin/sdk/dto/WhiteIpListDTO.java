package com.github.itdachen.admin.sdk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;

/**
 * 菜单白名单 DTO
 *
 * @author 王大宸
 * @date 2024-04-20 22:16:38
 */
public class WhiteIpListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

        /** 主键唯一标识 */
        private String id;

        /** 应用ID/appID */
 @NotBlank(message = "应用ID/appID不能为空")
        private String appId;

        /** 类型: menu-菜单;element-按钮 */
 @NotBlank(message = "类型: menu-菜单;element-按钮不能为空")
        private String ipType;

        /** 菜单ID */
 @NotBlank(message = "菜单ID不能为空")
        private String menuId;

        /** 菜单名称 */
 @NotBlank(message = "菜单名称不能为空")
        private String menuTitle;

        /** 按钮ID */
 @NotBlank(message = "按钮ID不能为空")
        private String elementId;

        /** 按钮名称 */
 @NotBlank(message = "按钮名称不能为空")
        private String elementTitle;

        /** 白名单类型 */
 @NotBlank(message = "白名单类型不能为空")
        private String typeId;

        /** 类型名: 固定IP/范围IP */
 @NotBlank(message = "类型名: 固定IP/范围IP不能为空")
        private String typeTitle;

        /** 固定IP */
 @NotBlank(message = "固定IP不能为空")
        private String hostIp;

        /** 固定IP的值 */
 @NotBlank(message = "固定IP的值不能为空")
        private String hostIpValue;

        /** 起始IP */
 @NotBlank(message = "起始IP不能为空")
        private String startIp;

        /** 起始IP的值 */
 @NotBlank(message = "起始IP的值不能为空")
        private String startIpValue;

        /** 结束IP */
 @NotBlank(message = "结束IP不能为空")
        private String endIp;

        /** 结束IP的值 */
 @NotBlank(message = "结束IP的值不能为空")
        private String endIpValue;

        /** 是否展示/有效标志: Y-有效;N-无效 */
 @NotBlank(message = "是否展示/有效标志: Y-有效;N-无效不能为空")
        private String validFlag;

        /** 备注 */
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
                .toString();
    }

}
