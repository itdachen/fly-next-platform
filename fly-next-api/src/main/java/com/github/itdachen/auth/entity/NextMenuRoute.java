package com.github.itdachen.auth.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by 王大宸 on 2023/05/08 21:01
 * Created with IntelliJ IDEA.
 */
public class NextMenuRoute  implements Serializable {
    private static final long serialVersionUID = 8703327259466887091L;

    private String path;

    private String name;

    private String component;

    private NextMetaMenu meta;

    private String redirect;

    private List<NextMenuRoute> children = new ArrayList<>();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public NextMetaMenu getMeta() {
        return meta;
    }

    public void setMeta(NextMetaMenu meta) {
        this.meta = meta;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public List<NextMenuRoute> getChildren() {
        return children;
    }

    public void setChildren(List<NextMenuRoute> children) {
        this.children = children;
    }
}
