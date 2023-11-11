package com.github.itdachen.admin.sdk.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Description: 数据字典返回给前端的对象
 * Created by 王大宸 on 2023/04/04 21:55
 * Created with IntelliJ IDEA.
 */
public class DataDictVo implements Serializable {
    private static final long serialVersionUID = 4783199917281599414L;

    /**
     * 字典标签
     */
    private String label;

    /**
     * 字典键值
     */
    private String value;

    /**
     * 是否默认
     */
    private Boolean isDefault;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("label", getLabel())
                .append("value", getValue())
                .append("isDefault", getIsDefault())
                .toString();
    }

}
