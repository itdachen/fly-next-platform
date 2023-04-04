package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 部门管理 Vo
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
public class DeptInfoVo implements Serializable {
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


    public DeptInfoVo() {
    }

    public DeptInfoVo(String id, String title, String parentId, String remarks, String isCanDel, String personCharge) {
            this.id = id;
            this.title = title;
            this.parentId = parentId;
            this.remarks = remarks;
            this.isCanDel = isCanDel;
            this.personCharge = personCharge;
    }

    public static DeptInfoVoBuilder builder() {
        return new DeptInfoVoBuilder();
    }

    public static class DeptInfoVoBuilder {
            private String id;
            private String title;
            private String parentId;
            private String remarks;
            private String isCanDel;
            private String personCharge;

        public   DeptInfoVoBuilder() {
        }

            /* 主键唯一标识 */
            public DeptInfoVoBuilder id(String id) {
                this.id = id;
                return this;
            }
            /* 部门名称 */
            public DeptInfoVoBuilder title(String title) {
                this.title = title;
                return this;
            }
            /* 上级id */
            public DeptInfoVoBuilder parentId(String parentId) {
                this.parentId = parentId;
                return this;
            }
            /* 备注 */
            public DeptInfoVoBuilder remarks(String remarks) {
                this.remarks = remarks;
                return this;
            }
            /* 是否可删除: 1-可删除;0-不可删 */
            public DeptInfoVoBuilder isCanDel(String isCanDel) {
                this.isCanDel = isCanDel;
                return this;
            }
            /* 负责人 */
            public DeptInfoVoBuilder personCharge(String personCharge) {
                this.personCharge = personCharge;
                return this;
            }

        public DeptInfoVo build() {
            return new DeptInfoVo(                id, 
                title, 
                parentId, 
                remarks, 
                isCanDel, 
                personCharge
);
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
