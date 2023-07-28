package com.vadim.model;

import lombok.Data;

@Data
public class Car {
    private int id;
    private String vin;
    private String carMake;
    private String carModel;
    private int releaseYear;
    private String color;
    private int mass; // kilograms
    private int price; // $
}
