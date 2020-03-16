package com.excilys.parking.core.model;

import java.time.LocalTime;
import java.util.Objects;

public class ParkingTicket {
    private int id;
    private Client client;
    private LocalTime startTime;
    private LocalTime exitTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalTime exitTime) {
        this.exitTime = exitTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingTicket that = (ParkingTicket) o;
        return id == that.id &&
                Objects.equals(client, that.client) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(exitTime, that.exitTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, startTime, exitTime);
    }

    public ParkingTicket(Client client, LocalTime startTime, LocalTime exitTime) {
        this.client = client;
        this.startTime = startTime;
        this.exitTime = exitTime;
    }
}
