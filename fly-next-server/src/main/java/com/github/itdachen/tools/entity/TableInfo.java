package com.github.itdachen.tools.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 代码生成业务表
 *
 * @author 王大宸
 * @date 2022-08-10 15:11:50
 */
@Table(name = "sys_gen_table_info")
public class TableInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 表名称
     */
    @Column(name = "table_name")
    private String tableName;

    /**
     * 表描述
     */
    @Column(name = "table_comment")
    private String tableComment;

    /**
     * 实体类名称
     */
    @Column(name = "class_name")
    private String className;

    /**
     * 使用的模板（biz单表操作 default树表操作）
     */
    @Column(name = "tpl_category")
    private String tplCategory;

    /**
     * 生成包路径
     */
    @Column(name = "package_name")
    private String packageName;

    /**
     * 服务上下文
     */
    @Column(name = "context_path")
    private String contextPath;

    /**
     * 生成模块名
     */
    @Column(name = "module_name")
    private String moduleName;

    /**
     * 生成业务名(controller访问名, 例如: 模块名为 admin, 业务名为 user, controller 访问路径为: /admin/user)
     */
    @Column(name = "business_name")
    private String businessName;

    /**
     * 生成功能名
     */
    @Column(name = "function_name")
    private String functionName;

    /**
     * 生成功能作者
     */
    @Column(name = "function_author")
    private String functionAuthor;

    /**
     * 上级菜单目录id
     */
    @Column(name = "menu_id")
    private String menuId;

    /**
     * 生成代码方式（0 zip压缩包 1自定义路径）
     */
    @Column(name = "gen_type")
    private String genType;

    /**
     * 生成路径（不填默认项目路径）
     */
    @Column(name = "gen_path")
    private String genPath;

    /**
     * 其它生成选项
     */
    @Column(name = "options")
    private String options;

    /**
     * 备注
     */
    @Column(name = "remarks")
    private String remarks;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    private String createUserId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 更新人id
     */
    @Column(name = "update_user_id")
    private String updateUserId;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setTplCategory(String tplCategory) {
        this.tplCategory = tplCategory;
    }

    public String getTplCategory() {
        return tplCategory;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionAuthor(String functionAuthor) {
        this.functionAuthor = functionAuthor;
    }

    public String getFunctionAuthor() {
        return functionAuthor;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setGenType(String genType) {
        this.genType = genType;
    }

    public String getGenType() {
        return genType;
    }

    public void setGenPath(String genPath) {
        this.genPath = genPath;
    }

    public String getGenPath() {
        return genPath;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getOptions() {
        return options;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
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

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() {
        return updateUser;
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
                .append("tableName", getTableName())
                .append("tableComment", getTableComment())
                .append("className", getClassName())
                .append("tplCategory", getTplCategory())
                .append("packageName", getPackageName())
                .append("contextPath", getContextPath())
                .append("moduleName", getModuleName())
                .append("businessName", getBusinessName())
                .append("functionName", getFunctionName())
                .append("functionAuthor", getFunctionAuthor())
                .append("menuId", getMenuId())
                .append("genType", getGenType())
                .append("genPath", getGenPath())
                .append("options", getOptions())
                .append("remarks", getRemarks())
                .append("createTime", getCreateTime())
                .append("createUser", getCreateUser())
                .append("createUserId", getCreateUserId())
                .append("updateTime", getUpdateTime())
                .append("updateUser", getUpdateUser())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }


}
