package com.example.java;

import java.util.ArrayList;
import java.util.List;

public class Module {

    List<String> param = new ArrayList<>();
    private String typeId;

    public List<String> getParam() {
        return param;
    }

    public void setParam(List<String> param) {
        this.param = param;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Module{" +
                "param=" + param +
                ", typeId='" + typeId + '\'' +
                '}';
    }
}
