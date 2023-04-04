package com.github.itdachen.admin.sdk.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;

/**
 * 部门管理 请求参数数据
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public class DeptInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;


        /** 主键唯一标识 */
        private String id;


        /** 部门名称 */
        private String title;


        /** 上级id */
        private String parentId;


        /** 备注 */
        private String remarks;


        /** 是否可删除: 1-可删除;0-不可删 */
        private String isCanDel;


        /** 负责人 */
        private String personCharge;


    public DeptInfoDto() {}

    public DeptInfoDto(String id, String title, String parentId, String remarks, String isCanDel, String personCharge) {
            this.id = id;
            this.title = title;
            this.parentId = parentId;
            this.remarks = remarks;
            this.isCanDel = isCanDel;
            this.personCharge = personCharge;
    }

    public static DeptInfoDtoBuilder builder() {
        return new DeptInfoDtoBuilder();
    }

    public static class DeptInfoDtoBuilder {
            private String id;
            private String title;
            private String parentId;
            private String remarks;
            private String isCanDel;
            private String personCharge;

        public DeptInfoDtoBuilder() {}

            /* 主键唯一标识 */
            public DeptInfoDtoBuilder id(String id) {
                this.id = id;
                return this;
            }
            /* 部门名称 */
            public DeptInfoDtoBuilder title(String title) {
                this.title = title;
                return this;
            }
            /* 上级id */
            public DeptInfoDtoBuilder parentId(String parentId) {
                this.parentId = parentId;
                return this;
            }
            /* 备注 */
            public DeptInfoDtoBuilder remarks(String remarks) {
                this.remarks = remarks;
                return this;
            }
            /* 是否可删除: 1-可删除;0-不可删 */
            public DeptInfoDtoBuilder isCanDel(String isCanDel) {
                this.isCanDel = isCanDel;
                return this;
            }
            /* 负责人 */
            public DeptInfoDtoBuilder personCharge(String personCharge) {
                this.personCharge = personCharge;
                return this;
            }

        public DeptInfoDto build() {
            return new DeptInfoDto(id, title, parentId, remarks, isCanDel, personCharge);
        }

    }



            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
            }
            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitle() {
                return title;
            }
            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public String getParentId() {
                return parentId;
            }
            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getRemarks() {
                return remarks;
            }
            public void setIsCanDel(String isCanDel) {
                this.isCanDel = isCanDel;
            }

            public String getIsCanDel() {
                return isCanDel;
            }
            public void setPersonCharge(String personCharge) {
                this.personCharge = personCharge;
            }

            public String getPersonCharge() {
                return personCharge;
            }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                    .append("id", getId())
                    .append("title", getTitle())
                    .append("parentId", getParentId())
                    .append("remarks", getRemarks())
                    .append("isCanDel", getIsCanDel())
                    .append("personCharge", getPersonCharge())
                .toString();
    }

}
