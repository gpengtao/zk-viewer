package com.gpengtao.zkviewer.web.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Map;

/**
 * Created by gpengtao on 15/10/11.
 */
public class ZkViewModel {

    private String path;

    private String data;

    private String parentPath;

    private Map<String, String> childrenPath;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public Map<String, String> getChildrenPath() {
        return childrenPath;
    }

    public void setChildrenPath(Map<String, String> childrenPath) {
        this.childrenPath = childrenPath;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
