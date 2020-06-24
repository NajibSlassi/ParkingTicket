package com.excilys.parking.core.model;

public class Receipt {
    String vehicleType;
    String fuelType;
    long hour;
    long minute;
    long price;

    /**
     * Constructor of Recipe class
     *
     * @param vehicleType the vehicle type name
     * @param fuelType    the fuel type name
     * @param hour        the hour the vehicle entered
     * @param minute      the minute the vehicle entered
     * @param price       the total price to pay
     */
    public Receipt(String vehicleType, String fuelType, long hour, long minute, long price) {
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.hour = hour;
        this.minute = minute;
        this.price = price;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public long getHour() {
        return hour;
    }

    public void setHour(long hour) {
        this.hour = hour;
    }

    public long getMinute() {
        return minute;
    }

    public void setMinute(long minute) {
        this.minute = minute;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String minutesToDisplay = minute <= 10 ? "0"+ minute : String.valueOf(minute);
        return "- véhicule : " + vehicleType + " " + fuelType +
                "\n- temps passé : " + hour + "h" + minutesToDisplay +
                "\n- montant dû : " + price + " euro(s)";
    }
}
