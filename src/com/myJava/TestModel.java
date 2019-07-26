package com.myJava;

import java.util.Objects;

/**
 * @ClassName TestModel
 * @Author Gavin
 * @Date 2019/7/26 下午11:48
 **/


public class TestModel {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestModel testModel = (TestModel) o;
        return Objects.equals(name, testModel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private String name;

    public TestModel() {
    }
}

