package com.excilys.parking.console;

import com.excilys.parking.core.model.Car;
import com.excilys.parking.core.model.Client;
import com.excilys.parking.core.model.ParkingTicket;

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;

public class PrintTicket {
    public static String printTicket(ParkingTicket ticket) {
        LocalTime start = ticket.getStartTime();
        LocalTime end = ticket.getExitTime();
        long duration = MINUTES.between(start, end);
        long hours = duration/60 +1;
        long minutes = duration%60;
        String carType = ticket.getClient().getCar().getCarType();
        int price = ticket.getClient().getCar().getPrice();
        String text = "- véhicule : "+ carType +"\n- temps passé : " + (hours - 1) +"h"+minutes + "\n- montant dû : " + price*hours + " euro(s)";
        return text;
    }

    public static void main(String[] args) {
        Client client1 = new Client(Car.TWOWHEELES);
        Client client2 = new Client(Car.FOURWHEELES);
        LocalTime startTime = LocalTime.of(10,0);
        LocalTime endTime = LocalTime.of(11,46);
        ParkingTicket ticket1 = new ParkingTicket(client1, startTime, endTime);
        ParkingTicket ticket2 = new ParkingTicket(client2, startTime, endTime);
        System.out.println(printTicket(ticket1));
        System.out.println("------------------------");
        System.out.println(printTicket(ticket2));
    }
}
