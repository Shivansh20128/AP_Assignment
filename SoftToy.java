package com.brickBracker;

public class SoftToy {
    private String toy_name;
    public SoftToy(){ }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setToy_name(String toy_name) {
        this.toy_name = toy_name;
    }

    public String getToy_name() {
        return toy_name;
    }
}
