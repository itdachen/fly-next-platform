package com.github.itdachen.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 数据字典类型
 *
 * @author 王大宸
 * @date 2024-04-21 20:21:24
 */
@Table(name = "ta_fly_dict_type")
public class DictType implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 数据字典类型ID
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 字典标签
     */
    @Column(name = "dict_label")
    private String dictLabel;

    /**
     * 字典类型
     */
    @Column(name = "dict_type")
    private String dictType;

    /**
     * 字典排序
     */
    @Column(name = "dict_sort")
    private Integer dictSort;

    /**
     * 是否默认
     */
    @Column(name = "is_default")
    private Boolean isDefault;

    /**
     * 有效标志
     */
    @Column(name = "valid_flag")
    private String validFlag;

    /**
     * 备注
     */
    @Column(name = "remarks")
    private String remarks;

    /**
     * 创建者
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * create_user_id
     */
    @Column(name = "create_user_id")
    private String createUserId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /**
     * update_user_id
     */
    @Column(name = "update_user_id")
    private String updateUserId;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public Integer getDictSort() {
        return dictSort;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getIsDefault() {
        return isDefault;
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

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("dictLabel", getDictLabel())
                .append("dictType", getDictType())
                .append("dictSort", getDictSort())
                .append("isDefault", getIsDefault())
                .append("validFlag", getValidFlag())
                .append("remarks", getRemarks())
                .append("createUser", getCreateUser())
                .append("createUserId", getCreateUserId())
                .append("createTime", getCreateTime())
                .append("updateUser", getUpdateUser())
                .append("updateTime", getUpdateTime())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }


}
