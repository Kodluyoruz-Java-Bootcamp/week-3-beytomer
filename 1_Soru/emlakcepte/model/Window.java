package com.emlakcepte.model;

import java.util.List;

public class Window {

    private List<Realty> windowRealtyList;
    private String name;

    public Window(List<Realty> realtyList, String name) {
        this.windowRealtyList = realtyList;
        this.name = name;
    }

    public List<Realty> getWindowRealtyList() {
        return windowRealtyList;
    }

    public void setWindowRealtyList(List<Realty> windowRealtyList) {
        this.windowRealtyList = windowRealtyList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
