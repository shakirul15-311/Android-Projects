package com.wix.boss.daily;

/**
 * Created by MNH on 5/12/2017.
 */

public class Dates {

    String name;
    int cost;

    public Dates() {
    }

    public Dates(String name, int cost, String type) {
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    String type;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
