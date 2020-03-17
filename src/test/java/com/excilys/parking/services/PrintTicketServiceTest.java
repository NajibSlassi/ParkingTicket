package com.excilys.parking.services;

import com.excilys.parking.core.model.FuelType;
import com.excilys.parking.core.model.Vehicle;
import com.excilys.parking.core.model.VehicleType;
import com.excilys.parking.core.model.ParkingTicket;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

public class PrintTicketServiceTest {
    private PrintTicketService service = new PrintTicketService();

    @Test
    public void compute_number_of_minutes_between_two_times_same_day() {
        LocalDateTime startDateTime = LocalDateTime.of(2019,3,17,10,10 );
        LocalDateTime endDateTime = LocalDateTime.of(2019,3,17,11,10 );

        long numberOfMinutesSpent = service.computeNumberOfMinutesSpent(startDateTime, endDateTime);
        assertThat(numberOfMinutesSpent).isEqualTo(60);
    }

    @Test
    public void compute_number_of_minutes_between_two_times_one_day_difference() {
        LocalDateTime startDateTime = LocalDateTime.of(2019,3,17,10,10 );
        LocalDateTime endDateTime = LocalDateTime.of(2019,3,18,10,10 );

        long numberOfMinutesSpent = service.computeNumberOfMinutesSpent(startDateTime, endDateTime);
        assertThat(numberOfMinutesSpent).isEqualTo(1440);
    }

    @Test
    public void compute_number_of_started_hours_in_an_amount_of_minutes_in_10_min() {
        long numberOfMinutesSpent = service.computeNumberOfStartedHours(10);
        assertThat(numberOfMinutesSpent).isEqualTo(1);
    }

    @Test
    public void compute_number_of_minutes_spent_in_last_hours_when_60_min_is_spent() {
        long numberOfMinutesSpentInLastHour = service.computeNumberOfMinutesSpentInLastHour(60);
        assertThat(numberOfMinutesSpentInLastHour).isEqualTo(0);
    }

    @Test
    public void compute_price_of_a_fourwheeles_gasoline_spent_60_min() {
        Vehicle vehicule = new Vehicle(VehicleType.FOURWHEELES, FuelType.GASOLINE);
        long numberOfMinutesSpentInLastHour = (long) service.computePrice(vehicule, 60);
        assertThat(numberOfMinutesSpentInLastHour).isEqualTo(4);
    }

    @Test
    public void return_formatted_time_spent_between_two_times_spaced_by_1h24() {
        LocalDateTime startDateTime = LocalDateTime.of(2019,3,17,10,10 );
        LocalDateTime endDateTime = LocalDateTime.of(2019,3,18,10,10 );

        String timeSpentFormatted = service.timeSpentFormatted(1,24);
        assertThat(timeSpentFormatted).isEqualTo("1h24");
    }

    @Test
    public void printing_ticket_between_two_times_same_day() {
        Vehicle vehicle = new Vehicle(VehicleType.TWOWHEELES, FuelType.GASOLINE);
        LocalDateTime startDateTime = LocalDateTime.of(2019,3,17,10,10 );
        LocalDateTime endDateTime = LocalDateTime.of(2019,3,17,11,10 );
        ParkingTicket ticket1 = new ParkingTicket(vehicle, startDateTime, endDateTime);
        String expectedOutPut = "- véhicule : moto essence\n- temps passé : 1h0\n- montant dû : 2 euro(s)";
        assertThat(service.printTicket(ticket1)).isEqualTo(expectedOutPut);
    }

    @Test
    public void return_text_between_two_times_different_days() {
        String text = service.textPrinted("vehicle", "fuel", "00h00", 4);
        String expectedOutPut = "- véhicule : vehicle fuel\n- temps passé : 00h00\n- montant dû : 4 euro(s)";
        assertThat(text).isEqualTo(expectedOutPut);
    }

    @Test
    public void printing_ticket_between_two_times_different_days() {
        Vehicle vehicle = new Vehicle(VehicleType.TWOWHEELES, FuelType.GASOLINE);
        LocalDateTime startDateTime = LocalDateTime.of(2019,3,17,10,10 );
        LocalDateTime endDateTime = LocalDateTime.of(2019,3,18,10,10 );
        ParkingTicket ticket1 = new ParkingTicket(vehicle, startDateTime, endDateTime);
        String expectedOutPut = "- véhicule : moto essence\n- temps passé : 24h0\n- montant dû : 2 euro(s)";
        assertThat(service.printTicket(ticket1)).isEqualTo(expectedOutPut);
    }

}
