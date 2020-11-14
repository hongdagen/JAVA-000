package com.hyhy.spring.fx.POJO;

import lombok.Data;

@Data
public class DotaHeroInfo {
    private String name;
    private Integer strength;
    private Integer agility;
    private Integer intelligence;
    private Boolean isCarry;

    public DotaHeroInfo() {
        this.name = "XXX";
        this.strength = -1;
        this.agility = -1;
        this.intelligence = -1;
        this.isCarry = false;
    }

    @Override
    public String toString() {
        return "DotaHeroInfo{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", isCarry=" + isCarry +
                '}';
    }
}
