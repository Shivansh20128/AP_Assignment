package com.brickBracker;

public class SoftToy implements Cloneable {
    private String toy_name;
    public SoftToy(){ }

    @Override
    public SoftToy clone() throws CloneNotSupportedException {
        return (SoftToy) super.clone();
    }


    public void setToy_name(String toy_name) {
        this.toy_name = toy_name;
    }

    public String getToy_name() {
        return toy_name;
    }
}
