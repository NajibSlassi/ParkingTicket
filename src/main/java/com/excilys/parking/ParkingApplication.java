package com.excilys.parking;

import com.excilys.parking.core.model.FuelType;
import com.excilys.parking.core.model.ParkingTicket;
import com.excilys.parking.core.model.Vehicle;
import com.excilys.parking.core.model.VehicleType;
import com.excilys.parking.services.PrintTicketService;

import java.time.LocalDateTime;

public class ParkingApplication {

    public static PrintTicketService printTicketService = new PrintTicketService();

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle(VehicleType.TWOWHEELES, FuelType.GASOLINE);
        Vehicle vehicle2 = new Vehicle(VehicleType.FOURWHEELES, FuelType.GASOLINE);
        LocalDateTime startDateTime = LocalDateTime.of(2019, 3, 17, 10, 10);
        LocalDateTime exitDateime = LocalDateTime.of(2019, 3, 17, 11, 10);
        ParkingTicket ticket1 = new ParkingTicket(vehicle1, startDateTime, exitDateime);
        ParkingTicket ticket2 = new ParkingTicket(vehicle2, startDateTime, exitDateime);
        System.out.println(printTicketService.printTicket(ticket1));
        System.out.println("-------------------------------------");
        System.out.println(printTicketService.printTicket(ticket2));
    }
}
