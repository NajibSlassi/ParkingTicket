package com.excilys.parking.services;

import com.excilys.parking.core.model.Recipe;
import com.excilys.parking.core.model.Vehicle;
import com.excilys.parking.core.model.ParkingTicket;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.MINUTES;


public class PrintTicketService {

    /**
     * The price of fuel per hour started
     */
    public static long PRICE = 4;

    /**
     * computes minutes spent between two localDateTimes.
     *
     * @param start the time the vehicle entered the parking
     * @param end   the time the vehicle exited the parking
     * @return minutesSpent
     */
    public long computeNumberOfMinutesSpent(LocalDateTime start, LocalDateTime end) {
        long minutesSpent = MINUTES.between(start, end);
        return minutesSpent;
    }

    /**
     * computes number of started hours using total number of minutes spent.
     *
     * @param minutesSpent the total count of minutes spent in the parking
     * @return startedHours
     */
    public long computeNumberOfStartedHours(long minutesSpent) {
        long startedHours = minutesSpent / 60 + 1;
        return startedHours;
    }

    /**
     * compute the minutes part to display.
     *
     * @param minutesSpent the total count of minutes spent in the parking
     * @return
     */
    public long computeNumberOfMinutesSpentInLastHour(long minutesSpent) {
        long minutes = minutesSpent % 60;
        return minutes;
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
        float result = PRICE * vehicleRatio * fuelRatio;

        return result;
    }

    /**
     * print the ticket using a ticket object.
     *
     * @param ticket
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
        Recipe recipe = new Recipe(vehicleTypeName, fuelTypeName, startedHours - 1, minutesSpentInLastHour, price);
        return recipe.toString();
    }
}
