package com.excilys.parking.core.model;

/*
Exercise statements didn't noted the fuel type but the example did, so I created FuelType enum
and set the ratio to 1 for the moment.
 */
public enum FuelType {
    GASOLINE("essence", 1),
    ELECTRIC("electrical", 1);

    private String name;
    private float ratio;

    /**
     * private Constructor to bind enum with ratio and name.
     *
     * @param name
     * @param ratio
     */
    private FuelType(String name, float ratio) {
        this.name = name;
        this.ratio = ratio;
    }

    /**
     * getter of price ratio for the fuel.
     *
     * @return ratio
     */
    public float getRatio() {
        return ratio;
    }

    /**
     * getter of fuel name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }
}
