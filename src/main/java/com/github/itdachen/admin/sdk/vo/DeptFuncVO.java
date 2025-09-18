package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 部门职能管理 VO
 *
 * @author 王大宸
 * @date 2025-09-18 23:03:17
 */
public class DeptFuncVO implements Serializable {
    private static final long serialVersionUID = 1L;

        /** ID/类型代码 */
        private String id;

        /** 租户ID */
        private String tenantId;

        /** 部门职能编码, 例如: 001-销售;002-研发 */
        private String funcCode;

        /** 职能标题 */
        private String title;

        /** 职能简称 */
        private String titleAs;

        /** 有效标志: Y-有效;N-无效 */
        private String validFlag;

        /** 备注 */
        private String remarks;



            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
            }

            public void setTenantId(String tenantId) {
                this.tenantId = tenantId;
            }

            public String getTenantId() {
                return tenantId;
            }

            public void setFuncCode(String funcCode) {
                this.funcCode = funcCode;
            }

            public String getFuncCode() {
                return funcCode;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitle() {
                return title;
            }

            public void setTitleAs(String titleAs) {
                this.titleAs = titleAs;
            }

            public String getTitleAs() {
                return titleAs;
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
                    .append("tenantId", getTenantId())
                    .append("funcCode", getFuncCode())
                    .append("title", getTitle())
                    .append("titleAs", getTitleAs())
                    .append("validFlag", getValidFlag())
                    .append("remarks", getRemarks())
                .toString();
    }

}
