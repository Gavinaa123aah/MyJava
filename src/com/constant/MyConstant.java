package com.constant;

public enum MyConstant {
    GOOD("good", 200),
    BAD("bad", 300);

    private int code;
    private String mode;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }



    MyConstant(String mode, int code) {
        this.mode = mode;
        this.code = code;
    }



}
