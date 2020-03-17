package com.excilys.parking.services;

/**
 * This class is used to gather all constants of the application.
 */
public final class Constants {
    private Constants(){}

    /**
     * The price of fuel per hour started
     */
    public static long PRICE= 4;

    /**
     * The price ratio for a four wheeles vehicle
     */
    public static float FOUR_WHEELES_RATIO = 1;
    /**
     * The price ratio for a two wheeles vehicle
     */
    public static float TWO_WHEELES_RATIO = (float) 0.5;

    /*
     Exercise statements didn't noted the fuel type but the example did, so I put those two constants
     and set them to 1 for the moment for further changes.
    */

    /**
     * price ratio for a gasoline vehicle
     */
    public static float GASOLINE_RATIO = 1;
    /**
     * price ratio for an electrical vehicle
     */
    public static float ELECTRIC_RATIO = 1;

    /*
    The next constants are used to display the ticket to users
     */
    public static String FOUR_WHEELES_NAME = "voiture";
    public static String TWO_WHEELES_NAME = "moto";
    public static String GASOLINE_NAME = "essence";
    public static String ELECTRIC_NAME = "éléctrique";

}
