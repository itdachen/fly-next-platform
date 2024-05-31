package com.github.itdachen.admin.sdk.query;

import com.github.itdachen.framework.core.biz.BizQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.io.Serializable;


/**
 * 租户/公司信息 查询参数
 *
 * @author 王大宸
 * @date 2024-04-24 22:42:35
 */
public class TenantInfoQuery extends BizQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 上级ID
     */
    private String parentId;

    /**
     * 行业代码
     */
    private String typeId;

    /**
     * 名称
     */
    private String title;

    /**
     * 简称
     */
    private String titleAs;

    /**
     * 拥有者ID
     */
    private String ownerId;

    /**
     * 拥有者昵称
     */
    private String ownerNickName;

    /**
     * 有效标志
     */
    private String validFlag;


    public TenantInfoQuery() {
    }

    public TenantInfoQuery(int page, int limit, String parentId, String typeId, String title, String titleAs, String ownerId, String ownerNickName, String validFlag) {
        super(page, limit);
        this.parentId = parentId;
        this.typeId = typeId;
        this.title = title;
        this.titleAs = titleAs;
        this.ownerId = ownerId;
        this.ownerNickName = ownerNickName;
        this.validFlag = validFlag;
    }

    public static TenantInfoQueryBuilder builder() {
        return new TenantInfoQueryBuilder();
    }

    public static class TenantInfoQueryBuilder {
        private Integer page = 1;
        private Integer limit = 10;
        private String parentId;
        private String typeId;
        private String title;
        private String titleAs;
        private String ownerId;
        private String ownerNickName;
        private String validFlag;

        public TenantInfoQueryBuilder() {
        }

        public TenantInfoQueryBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public TenantInfoQueryBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /* 上级ID */
        public TenantInfoQueryBuilder parentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        /* 行业代码 */
        public TenantInfoQueryBuilder typeId(String typeId) {
            this.typeId = typeId;
            return this;
        }

        /* 名称 */
        public TenantInfoQueryBuilder title(String title) {
            this.title = title;
            return this;
        }

        /* 简称 */
        public TenantInfoQueryBuilder titleAs(String titleAs) {
            this.titleAs = titleAs;
            return this;
        }

        /* 拥有者ID */
        public TenantInfoQueryBuilder ownerId(String ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        /* 拥有者昵称 */
        public TenantInfoQueryBuilder ownerNickName(String ownerNickName) {
            this.ownerNickName = ownerNickName;
            return this;
        }

        /* 有效标志 */
        public TenantInfoQueryBuilder validFlag(String validFlag) {
            this.validFlag = validFlag;
            return this;
        }

        public TenantInfoQuery build() {
            return new TenantInfoQuery(page, limit, parentId, typeId, title, titleAs, ownerId, ownerNickName, validFlag);
        }

    }


    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
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

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerNickName(String ownerNickName) {
        this.ownerNickName = ownerNickName;
    }

    public String getOwnerNickName() {
        return ownerNickName;
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
                .append("parentId", getParentId())
                .append("typeId", getTypeId())
                .append("title", getTitle())
                .append("titleAs", getTitleAs())
                .append("ownerId", getOwnerId())
                .append("ownerNickName", getOwnerNickName())
                .append("validFlag", getValidFlag())
                .toString();
    }

}
