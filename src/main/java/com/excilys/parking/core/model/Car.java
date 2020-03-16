package com.excilys.parking.core.model;

public enum Car {
    TWOWHEELES("voiture essence", 1),
    FOURWHEELES("moto essence", 2);
    private String carType;
    private int price;
    Car(String carType, int price) {
        this.carType = carType;
        this.price = price;
    }

    public String getCarType() {
        return carType;
    }

    public int getPrice() {
        return price;
    }
}
