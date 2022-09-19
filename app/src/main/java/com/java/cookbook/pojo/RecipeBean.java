package com.java.cookbook.pojo;

import java.io.Serializable;
import java.util.List;

public class RecipeBean implements Serializable {
    private String cpName;
    private String ct;
    private String des;
    private String id;
    private String largeImg;
    private String smallImg;
    private String tip;
    private String type;
    private String type_v1;
    private String type_v2;
    private String type_v3;
    private List<StepBean> steps;
    private List<YlBean> yl;

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLargeImg() {
        return largeImg;
    }

    public void setLargeImg(String largeImg) {
        this.largeImg = largeImg;
    }

    public String getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType_v1() {
        return type_v1;
    }

    public void setType_v1(String type_v1) {
        this.type_v1 = type_v1;
    }

    public String getType_v2() {
        return type_v2;
    }

    public void setType_v2(String type_v2) {
        this.type_v2 = type_v2;
    }

    public String getType_v3() {
        return type_v3;
    }

    public void setType_v3(String type_v3) {
        this.type_v3 = type_v3;
    }

    public List<StepBean> getSteps() {
        return steps;
    }

    public void setSteps(List<StepBean> steps) {
        this.steps = steps;
    }

    public List<YlBean> getYl() {
        return yl;
    }

    public void setYl(List<YlBean> yl) {
        this.yl = yl;
    }


}
