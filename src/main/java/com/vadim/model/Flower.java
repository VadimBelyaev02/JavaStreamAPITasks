package com.vadim.model;

import lombok.Data;

import java.util.List;

@Data
public class Flower {
    private int id;
    private String commonName;
    private String plantFamily;
    private double waterConsumptionPerDay;
    private boolean shadePreferred;
    private String origin;
    private int price;
    private List<String> flowerVaseMaterial;

//    public boolean getShadePreferred() {
//        return this.shadePreferred;
//    }
}
