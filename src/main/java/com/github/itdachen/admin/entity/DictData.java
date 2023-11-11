package com.github.itdachen.admin.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;



/**
 * 字典数据表
 *
 * @author 王大宸
 * @date 2023-04-04 21:44:47
 */
@Table(name = "sys_dict_data")
public class DictData implements Serializable{
private static final long serialVersionUID=1L;

    /** 字典id */
    @Id
    @Column(name = "id")
    private String id;

    /** 字典排序 */
    @Column(name = "dict_sort")
    private Integer dictSort;

    /** 字典标签 */
    @Column(name = "dict_label")
    private String dictLabel;

    /** 字典键值 */
    @Column(name = "dict_value")
    private String dictValue;

    /** 字典类型 */
    @Column(name = "dict_type")
    private String dictType;

    /** 样式属性（其他样式扩展） */
    @Column(name = "css_class")
    private String cssClass;

    /** 表格回显样式 */
    @Column(name = "list_class")
    private String listClass;

    /** 是否默认（Y是 N否） */
    @Column(name = "is_default")
    private String isDefault;

    /** 状态,数据字典:dict_data_status */
    @Column(name = "status")
    private String status;

    /** 备注 */
    @Column(name = "remarks")
    private String remarks;

    /** 创建者 */
    @Column(name = "create_user")
    private String createUser;

    /** 创建者ID */
    @Column(name = "create_user_id")
    private String createUserId;

    /** 创建时间 */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /** 更新者 */
    @Column(name = "update_user")
    private String updateUser;

    /** 更新时间 */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /** 更新者ID */
    @Column(name = "update_user_id")
    private String updateUserId;


public DictData(){}


public DictData(    String id,     Integer dictSort,     String dictLabel,     String dictValue,     String dictType,     String cssClass,     String listClass,     String isDefault,     String status,     String remarks,     String createUser,     String createUserId,     LocalDateTime createTime,     String updateUser,     LocalDateTime updateTime,     String updateUserId){
            this.id = id;
            this.dictSort = dictSort;
            this.dictLabel = dictLabel;
            this.dictValue = dictValue;
            this.dictType = dictType;
            this.cssClass = cssClass;
            this.listClass = listClass;
            this.isDefault = isDefault;
            this.status = status;
            this.remarks = remarks;
            this.createUser = createUser;
            this.createUserId = createUserId;
            this.createTime = createTime;
            this.updateUser = updateUser;
            this.updateTime = updateTime;
            this.updateUserId = updateUserId;
}

public static DictDataBuilder builder(){
        return new DictDataBuilder();
        }

public static class DictDataBuilder {
        private String id;
        private Integer dictSort;
        private String dictLabel;
        private String dictValue;
        private String dictType;
        private String cssClass;
        private String listClass;
        private String isDefault;
        private String status;
        private String remarks;
        private String createUser;
        private String createUserId;
        private LocalDateTime createTime;
        private String updateUser;
        private LocalDateTime updateTime;
        private String updateUserId;

    public DictDataBuilder() {
    }

        /* 字典id */
        public DictDataBuilder id(String id) {
            this.id = id;
            return this;
        }
        /* 字典排序 */
        public DictDataBuilder dictSort(Integer dictSort) {
            this.dictSort = dictSort;
            return this;
        }
        /* 字典标签 */
        public DictDataBuilder dictLabel(String dictLabel) {
            this.dictLabel = dictLabel;
            return this;
        }
        /* 字典键值 */
        public DictDataBuilder dictValue(String dictValue) {
            this.dictValue = dictValue;
            return this;
        }
        /* 字典类型 */
        public DictDataBuilder dictType(String dictType) {
            this.dictType = dictType;
            return this;
        }
        /* 样式属性（其他样式扩展） */
        public DictDataBuilder cssClass(String cssClass) {
            this.cssClass = cssClass;
            return this;
        }
        /* 表格回显样式 */
        public DictDataBuilder listClass(String listClass) {
            this.listClass = listClass;
            return this;
        }
        /* 是否默认（Y是 N否） */
        public DictDataBuilder isDefault(String isDefault) {
            this.isDefault = isDefault;
            return this;
        }
        /* 状态,数据字典:dict_data_status */
        public DictDataBuilder status(String status) {
            this.status = status;
            return this;
        }
        /* 备注 */
        public DictDataBuilder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }
        /* 创建者 */
        public DictDataBuilder createUser(String createUser) {
            this.createUser = createUser;
            return this;
        }
        /* 创建者ID */
        public DictDataBuilder createUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }
        /* 创建时间 */
        public DictDataBuilder createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }
        /* 更新者 */
        public DictDataBuilder updateUser(String updateUser) {
            this.updateUser = updateUser;
            return this;
        }
        /* 更新时间 */
        public DictDataBuilder updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }
        /* 更新者ID */
        public DictDataBuilder updateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
            return this;
        }

    public DictData build() {
        return new DictData(            id, 
            dictSort, 
            dictLabel, 
            dictValue, 
            dictType, 
            cssClass, 
            listClass, 
            isDefault, 
            status, 
            remarks, 
            createUser, 
            createUserId, 
            createTime, 
            updateUser, 
            updateTime, 
            updateUserId
);
    }

}


            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
            }

            public void setDictSort(Integer dictSort) {
                this.dictSort = dictSort;
            }

            public Integer getDictSort() {
                return dictSort;
            }

            public void setDictLabel(String dictLabel) {
                this.dictLabel = dictLabel;
            }

            public String getDictLabel() {
                return dictLabel;
            }

            public void setDictValue(String dictValue) {
                this.dictValue = dictValue;
            }

            public String getDictValue() {
                return dictValue;
            }

            public void setDictType(String dictType) {
                this.dictType = dictType;
            }

            public String getDictType() {
                return dictType;
            }

            public void setCssClass(String cssClass) {
                this.cssClass = cssClass;
            }

            public String getCssClass() {
                return cssClass;
            }

            public void setListClass(String listClass) {
                this.listClass = listClass;
            }

            public String getListClass() {
                return listClass;
            }

            public void setIsDefault(String isDefault) {
                this.isDefault = isDefault;
            }

            public String getIsDefault() {
                return isDefault;
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
                    .append("dictSort", getDictSort())
                    .append("dictLabel", getDictLabel())
                    .append("dictValue", getDictValue())
                    .append("dictType", getDictType())
                    .append("cssClass", getCssClass())
                    .append("listClass", getListClass())
                    .append("isDefault", getIsDefault())
                    .append("status", getStatus())
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
