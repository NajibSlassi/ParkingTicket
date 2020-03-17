package com.excilys.parking.core.model;

public enum VehicleType {
    TWOWHEELES("moto", (float) 0.5),
    FOURWHEELES("voiture", 1);

    private float ratio;
    private String name;

    /**
     * Constructor of VehicleType
     *
     * @param name  vehicle type's name
     * @param ratio vehicle type's ratio
     */
    VehicleType(String name, float ratio) {
        this.name = name;
        this.ratio = ratio;
    }

    public float getRatio() {
        return ratio;
    }

    public String getName() {
        return name;
    }
}
