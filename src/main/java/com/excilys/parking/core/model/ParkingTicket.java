package com.excilys.parking.core.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class ParkingTicket {
    private int id;
    private Vehicle vehicle;
    private LocalDateTime startDateTime;
    private LocalDateTime exitDateTime;

    /**
     * Constructor of ParkingTicket.
     *
     * @param vehicle       the vehicle object
     * @param startDateTime the time the vehicle entered the parking
     * @param exitDateTime  the time the vehicle exited the parking
     */
    public ParkingTicket(Vehicle vehicle, LocalDateTime startDateTime, LocalDateTime exitDateTime) {
        this.vehicle = vehicle;
        this.startDateTime = startDateTime;
        this.exitDateTime = exitDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalTime startDateTime) {
        this.startDateTime = this.startDateTime;
    }

    public LocalDateTime getExitDateTime() {
        return exitDateTime;
    }

    public void setExitDateTime(LocalDateTime exitDateTime) {
        this.exitDateTime = this.exitDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingTicket that = (ParkingTicket) o;
        return id == that.id &&
                Objects.equals(vehicle, that.vehicle) &&
                Objects.equals(startDateTime, that.startDateTime) &&
                Objects.equals(exitDateTime, that.exitDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vehicle, startDateTime, exitDateTime);
    }
}
