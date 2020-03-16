package com.excilys.parking.core.model;

import java.util.Objects;

public class Client {
    private int id;
    private Car car;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                car == client.car;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car);
    }

    public Client(Car car) {
        this.car = car;
    }
}
