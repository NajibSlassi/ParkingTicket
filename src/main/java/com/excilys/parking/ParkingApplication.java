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
        Vehicle vehicle1 = new Vehicle(VehicleType.FOURWHEELES, FuelType.GASOLINE);
        Vehicle vehicle2 = new Vehicle(VehicleType.TWOWHEELES, FuelType.GASOLINE);
        LocalDateTime startDateTimeV1 = LocalDateTime.of(2019, 3, 17, 13, 24);
        LocalDateTime startDateTimeV2 = LocalDateTime.of(2019, 3, 17, 19, 30);
        LocalDateTime exitDateimeV1 = LocalDateTime.of(2019, 3, 17, 15, 10);
        LocalDateTime exitDateimeV2 = LocalDateTime.of(2019, 3, 18, 00, 37);
        ParkingTicket ticket1 = new ParkingTicket(vehicle1, startDateTimeV1, exitDateimeV1);
        ParkingTicket ticket2 = new ParkingTicket(vehicle2, startDateTimeV2, exitDateimeV2);
        System.out.println(printTicketService.printTicket(ticket1));
        System.out.println("-------------------------------------");
        System.out.println(printTicketService.printTicket(ticket2));
    }
}
