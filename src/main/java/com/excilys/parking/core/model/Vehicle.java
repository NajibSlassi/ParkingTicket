package com.excilys.parking.core.model;

import java.util.Objects;

public class Vehicle {
    private VehicleType vehicleType;
    private FuelType fuelType;

    /**
     * Vehicle class contructor.
     *
     * @param vehicleType the enum corresponding to vehicle type
     * @param fuelType    the enum corresponding to fuel type
     */
    public Vehicle(VehicleType vehicleType, FuelType fuelType) {
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleType == vehicle.vehicleType &&
                fuelType == vehicle.fuelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleType, fuelType);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "carType=" + vehicleType +
                ", fuelType=" + fuelType +
                '}';
    }
}
