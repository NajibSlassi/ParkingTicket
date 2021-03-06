package com.excilys.parking.services;

import com.excilys.parking.core.model.Receipt;
import com.excilys.parking.core.model.Vehicle;
import com.excilys.parking.core.model.ParkingTicket;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.MINUTES;


public class PrintTicketService {

    /**
     * The price of fuel per hour started
     */
    public static long PRICE = 2;

    /**
     * Number of minutes in 1 hour
     */
    public static long NUMBER_OF_MINUTES_IN_ONE_HOUR = 60;

    private static PrintTicketService instance;
    private PrintTicketService() {
    }

    public static synchronized PrintTicketService getInstance() {
        if(instance == null) {
            instance = new PrintTicketService();
        }
        return instance;
    }

    /**
     * computes minutes spent between two localDateTimes.
     *
     * @param start the time the vehicle entered the parking
     * @param end   the time the vehicle exited the parking
     * @return minutesSpent
     */
    public long computeNumberOfMinutesSpent(LocalDateTime start, LocalDateTime end) {
        return MINUTES.between(start, end);
    }

    /**
     * computes number of started hours using total number of minutes spent.
     *
     * @param minutesSpent the total count of minutes spent in the parking
     * @return startedHours
     */
    public long computeNumberOfStartedHours(long minutesSpent) {
        return minutesSpent / NUMBER_OF_MINUTES_IN_ONE_HOUR + 1;
    }

    /**
     * compute the minutes part to display.
     *
     * @param minutesSpent the total count of minutes spent in the parking
     * @return minutes
     */
    public long computeNumberOfMinutesSpentInLastHour(long minutesSpent) {
        return minutesSpent % NUMBER_OF_MINUTES_IN_ONE_HOUR;
    }

    /**
     * computes the price using vehicle and number of started hours.
     *
     * @param vehicle              the vehicle object
     * @param numberOfStartedHours number of hours started by the vehicle in the parking
     * @return a float the result of computing
     */
    public float computePrice(Vehicle vehicle, long numberOfStartedHours) {
        float vehicleRatio = vehicle.getVehicleType().getRatio();
        float fuelRatio = vehicle.getFuelType().getRatio();

        return PRICE * vehicleRatio * fuelRatio * numberOfStartedHours;
    }

    /**
     * print the ticket using a ticket object.
     *
     * @param ticket the parking ticket
     * @return the text to print to the user
     */
    public String printTicket(ParkingTicket ticket) {
        LocalDateTime start = ticket.getStartDateTime();
        LocalDateTime exit = ticket.getExitDateTime();
        long minutesSpent = computeNumberOfMinutesSpent(start, exit);
        long startedHours = computeNumberOfStartedHours(minutesSpent);
        long minutesSpentInLastHour = computeNumberOfMinutesSpentInLastHour(minutesSpent);
        Vehicle vehicle = ticket.getVehicle();
        String vehicleTypeName = vehicle.getVehicleType().getName();
        String fuelTypeName = vehicle.getFuelType().getName();
        long price = (long) computePrice(vehicle, startedHours);
        Receipt receipt = new Receipt(vehicleTypeName, fuelTypeName, startedHours - 1, minutesSpentInLastHour, price);
        return receipt.toString();
    }
}
