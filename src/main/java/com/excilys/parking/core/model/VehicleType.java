package com.excilys.parking.core.model;
import static com.excilys.parking.services.Constants.*;

public enum VehicleType {
    TWOWHEELES(TWO_WHEELES_NAME, TWO_WHEELES_RATIO),
    FOURWHEELES(FOUR_WHEELES_NAME, FOUR_WHEELES_RATIO);

    private float ratio;
    private String name;

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
