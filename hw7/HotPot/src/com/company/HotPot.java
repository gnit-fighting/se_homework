package com.company;

public abstract class HotPot {
    public String name;

    public abstract void prepare();

    public void serve() {
        System.out.println(name + " serving");
    }

    public void cut() {
        System.out.println(name + " cutting");
    }

    public void setName(String name) {
        this.name = name;
    }
}
