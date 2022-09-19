package com.java.cookbook.pojo;

import java.io.Serializable;

public class YlBean implements Serializable {
    private String ylName;
    private String ylUnit;
    public String getYlName() {
        return ylName;
    }

    public void setYlName(String ylName) {
        this.ylName = ylName;
    }

    public String getYlUnit() {
        return ylUnit;
    }

    public void setYlUnit(String ylUnit) {
        this.ylUnit = ylUnit;
    }
}
