package com.excilys.parking.core.model;

import static com.excilys.parking.services.Constants.*;

public enum FuelType {
    GASOLINE(GASOLINE_NAME, GASOLINE_RATIO),
    ELECTRIC(ELECTRIC_NAME, ELECTRIC_RATIO);

    private String name;
    private float ratio;
    FuelType(String name, float ratio) {
        this.name = name;
        this.ratio = ratio;
    }

    /**
     * getter of price ratio for the fuel.
     * @return ratio
     */
    public float getRatio() {
        return ratio;
    }

    /**
     * getter of fuel name.
     * @return name
     */
    public String getName() {
        return name;
    }
}
