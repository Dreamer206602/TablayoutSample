package com.mx.tablayoutsample.model;

import java.io.Serializable;

/**
 * Created by hww on 2016/6/3.
 */
public class ReleatedEBookInfo implements Serializable{
    private String mId = "";
    private String mLabel = "";
    private String mTitle = "";
    private String mUrl = "";

    public ReleatedEBookInfo(){}

    public ReleatedEBookInfo(String title, String label) {
        setTitle(title);
        setLabel(label);
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String mLabel) {
        this.mLabel = mLabel;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
