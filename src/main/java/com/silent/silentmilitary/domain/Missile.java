package com.silent.silentmilitary.domain;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: Missile
 * @Description: TODO
 * @date 2019-01-31  14:55
 */

public class Missile {

    private  String name;
    private  String country;
    private  String type;

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getType() {
        return type;
    }
}
