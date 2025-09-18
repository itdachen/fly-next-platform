package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * 部门等级 VO
 *
 * @author 王大宸
 * @date 2025-09-18 22:02:49
 */
public class DeptLevelVO implements Serializable {
    private static final long serialVersionUID = 1L;

        /** 主键唯一标识 */
        private String id;

        /** 租户ID */
        private String tenantId;

        /** 层级代码 */
        private String levelCode;

        /** 层级名称,例如: 00-总部; 10-省级部门; 20-市州级部门; 30-区县级;40-乡镇级;50-社区/街道/村 */
        private String levelTitle;

        /** 有效标志: Y-是;N-否 */
        private String validFlag;

        /** 备注 */
        private String remarks;

        /** 删除标志:  Y-已删除;N-未删除 */
        private String deleteFlag;



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

            public void setLevelCode(String levelCode) {
                this.levelCode = levelCode;
            }

            public String getLevelCode() {
                return levelCode;
            }

            public void setLevelTitle(String levelTitle) {
                this.levelTitle = levelTitle;
            }

            public String getLevelTitle() {
                return levelTitle;
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

            public void setDeleteFlag(String deleteFlag) {
                this.deleteFlag = deleteFlag;
            }

            public String getDeleteFlag() {
                return deleteFlag;
            }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                    .append("id", getId())
                    .append("tenantId", getTenantId())
                    .append("levelCode", getLevelCode())
                    .append("levelTitle", getLevelTitle())
                    .append("validFlag", getValidFlag())
                    .append("remarks", getRemarks())
                    .append("deleteFlag", getDeleteFlag())
                .toString();
    }

}
