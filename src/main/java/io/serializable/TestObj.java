package io.serializable;

import java.io.Serializable;

/**
 * @className: TestObj
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/14 11:04
 * @version: 1.0
 */
public class TestObj implements Serializable {

    private String name;

    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
