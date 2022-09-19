package com.java.cookbook.pojo;

import java.io.Serializable;

public class StepBean implements Serializable {
    private String content;
    private String imgUrl;
    private int oderNum;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getOderNum() {
        return oderNum;
    }

    public void setOderNum(int oderNum) {
        this.oderNum = oderNum;
    }

}
