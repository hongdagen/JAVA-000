package com.hyhy.springboot.homework.POJO;

import lombok.Data;

@Data
public class DotaHeroInfo {
    private String name;
    private Integer strength;
    private Integer agility;
    private Integer intelligence;
    private Boolean isCarry;


    public DotaHeroInfo(String name) {
        this.name = name;
        this.strength = -1;
        this.agility = -1;
        this.intelligence = -1;
        this.isCarry = false;
    }

    public DotaHeroInfo(String name, Integer strength, Integer agility, Integer intelligence, Boolean isCarry) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.isCarry = isCarry;
    }

    public DotaHeroInfo(String name, Integer strength, Integer agility, Integer intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
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
