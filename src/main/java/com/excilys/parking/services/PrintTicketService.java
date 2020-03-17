package com.excilys.parking.services;

import com.excilys.parking.core.model.Vehicle;
import com.excilys.parking.core.model.ParkingTicket;

import static com.excilys.parking.services.Constants.PRICE;

import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.MINUTES;


public class PrintTicketService {
    /**
     * computes time spent between two localDateTimes.
     * @param start
     * @param end
     * @return minutesSpent
     */
    public long computeNumberOfMinutesSpent (LocalDateTime start, LocalDateTime end) {
        long minutesSpent = MINUTES.between(start, end);
        return minutesSpent;
    }

    /**
     * computes number of started hours using total number of minutes spent.
     * @param minutesSpent
     * @return startedHours
     */
    public long computeNumberOfStartedHours(long minutesSpent) {
        long startedHours = minutesSpent/60 +1;
        return startedHours;
    }

    /**
     * compute the minutes part to display.
     * @param minutesSpent
     * @return
     */
    public long computeNumberOfMinutesSpentInLastHour(long minutesSpent) {
        long minutes = minutesSpent%60;
        return minutes;
    }

    /**
     * computes the price using vehicle and number of started hours.
     * @param vehicle
     * @param numberOfStartedHours
     * @return a float the result of computing
     */
    public float computePrice(Vehicle vehicle, long numberOfStartedHours){
        float vehicleRatio = vehicle.getVehicleType().getRatio();
        float fuelRatio = vehicle.getFuelType().getRatio();
        float result = PRICE*vehicleRatio*fuelRatio;

        return result;
    }

    /**
     * returns a String containing the time formatted to HH:MM
     * @param hours
     * @param minutes
     * @return
     */
    public String timeSpentFormatted(long hours, long minutes){
        return hours+"h"+minutes;
    }

    /**
     *
     * @param vehicleType
     * @param fuelType
     * @param timeSpentFormatted
     * @param price
     * @return the text to print to user
     */
    public String textPrinted(String vehicleType, String fuelType, String timeSpentFormatted, long price){
        String text = "- véhicule : "+ vehicleType +" "+ fuelType +
                "\n- temps passé : " + timeSpentFormatted +
                "\n- montant dû : " + price + " euro(s)";
        return text;
    };

    /**
     * print the ticket using a ticket object.
     * @param ticket
     * @return the text to print to the user
     */
    public String printTicket(ParkingTicket ticket) {
        LocalDateTime start = ticket.getStartDateTime();
        LocalDateTime exit = ticket.getExitDateTime();
        long minutesSpent = computeNumberOfMinutesSpent (start, exit);
        long startedHours = computeNumberOfStartedHours(minutesSpent);
        long minutesSpentInLastHour = computeNumberOfMinutesSpentInLastHour(minutesSpent);
        Vehicle vehicle = ticket.getVehicle();
        String vehicleTypeName = vehicle.getVehicleType().getName();
        String fuelTypeName = vehicle.getFuelType().getName();
        long price = (long) computePrice(vehicle, startedHours);
        String timeSpentFormatted = timeSpentFormatted(startedHours-1, minutesSpentInLastHour);
        String text = textPrinted(vehicleTypeName, fuelTypeName, timeSpentFormatted, price);
        return text;
    }
}
