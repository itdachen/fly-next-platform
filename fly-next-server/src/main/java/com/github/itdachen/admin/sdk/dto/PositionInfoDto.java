package com.github.itdachen.admin.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;

/**
 * 岗位信息 请求参数数据
 *
 * @author 王大宸
 * @date 2023-05-15 20:13:36
 */
public class PositionInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键唯一标识
     */
    private String id;


    /**
     * 租户标识
     */
    private String tenantId;


    /**
     * 岗位名称
     */
    private String title;


    /**
     * 岗位标识
     */
    private String positionCode;


    /**
     * 所属部门
     */
    private String deptId;


    /**
     * 状态
     */
    private String status;


    /**
     * 备注
     */
    private String remarks;


    public PositionInfoDto() {
    }

    public PositionInfoDto(String id, String tenantId, String title, String positionCode, String deptId, String status, String remarks) {
        this.id = id;
        this.tenantId = tenantId;
        this.title = title;
        this.positionCode = positionCode;
        this.deptId = deptId;
        this.status = status;
        this.remarks = remarks;
    }

    public static PositionInfoDtoBuilder builder() {
        return new PositionInfoDtoBuilder();
    }

    public static class PositionInfoDtoBuilder {
        private String id;
        private String tenantId;
        private String title;
        private String positionCode;
        private String deptId;
        private String status;
        private String remarks;

        public PositionInfoDtoBuilder() {
        }

        /* 主键唯一标识 */
        public PositionInfoDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /* 租户标识 */
        public PositionInfoDtoBuilder tenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        /* 岗位名称 */
        public PositionInfoDtoBuilder title(String title) {
            this.title = title;
            return this;
        }

        /* 岗位标识 */
        public PositionInfoDtoBuilder positionCode(String positionCode) {
            this.positionCode = positionCode;
            return this;
        }

        /* 所属部门 */
        public PositionInfoDtoBuilder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        /* 状态 */
        public PositionInfoDtoBuilder status(String status) {
            this.status = status;
            return this;
        }

        /* 备注 */
        public PositionInfoDtoBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public PositionInfoDto build() {
            return new PositionInfoDto(id, tenantId, title, positionCode, deptId, status, remarks);
        }

    }


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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
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
                .append("title", getTitle())
                .append("positionCode", getPositionCode())
                .append("deptId", getDeptId())
                .append("status", getStatus())
                .append("remarks", getRemarks())
                .toString();
    }

}
