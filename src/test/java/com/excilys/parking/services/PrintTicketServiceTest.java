package com.excilys.parking.services;

import com.excilys.parking.core.model.FuelType;
import com.excilys.parking.core.model.Vehicle;
import com.excilys.parking.core.model.VehicleType;
import com.excilys.parking.core.model.ParkingTicket;
import org.junit.Test;

import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

public class PrintTicketServiceTest {
    private PrintTicketService service = PrintTicketService.getInstance();

    @Test
    public void compute_number_of_minutes_between_two_times_same_day() {
        //
        //Given
        //
        LocalDateTime startDateTime = LocalDateTime.of(2019,3,17,10,10 );
        LocalDateTime endDateTime = LocalDateTime.of(2019,3,17,11,10 );

        //
        //When
        //
        long numberOfMinutesSpent = service.computeNumberOfMinutesSpent(startDateTime, endDateTime);

        //
        //Then
        //
        assertThat(numberOfMinutesSpent).isEqualTo(60);
    }

    @Test
    public void compute_number_of_minutes_between_two_times_one_day_difference() {
        //
        //Given
        //
        LocalDateTime startDateTime = LocalDateTime.of(2019,3,17,10,10 );
        LocalDateTime endDateTime = LocalDateTime.of(2019,3,18,10,10 );
        //
        //When
        //
        long numberOfMinutesSpent = service.computeNumberOfMinutesSpent(startDateTime, endDateTime);

        //
        //Then
        //
        assertThat(numberOfMinutesSpent).isEqualTo(1440);
    }

    @Test
    public void compute_number_of_started_hours_in_an_amount_of_minutes_in_10_min() {
        //
        //When
        //
        long numberOfMinutesSpent = service.computeNumberOfStartedHours(10);

        //
        //Then
        //
        assertThat(numberOfMinutesSpent).isEqualTo(1);
    }

    @Test
    public void compute_number_of_minutes_spent_in_last_hours_when_60_min_is_spent() {
        //
        //When
        //
        long numberOfMinutesSpentInLastHour = service.computeNumberOfMinutesSpentInLastHour(60);

        //
        //Then
        //
        assertThat(numberOfMinutesSpentInLastHour).isEqualTo(0);
    }

    @Test
    public void compute_price_of_a_fourwheeles_gasoline_spent_60_min() {
        //
        //Given
        //
        Vehicle vehicle = new Vehicle(VehicleType.FOURWHEELES, FuelType.GASOLINE);

        //
        //When
        //
        long numberOfMinutesSpentInLastHour = (long) service.computePrice(vehicle, 1);

        //
        //Then
        //
        assertThat(numberOfMinutesSpentInLastHour).isEqualTo(2);
    }

    @Test
    public void printing_ticket_between_two_times_same_day() {
        //
        //Given
        //
        Vehicle vehicle = new Vehicle(VehicleType.TWOWHEELES, FuelType.GASOLINE);
        LocalDateTime startDateTime = LocalDateTime.of(2019,3,17,10,10 );
        LocalDateTime endDateTime = LocalDateTime.of(2019,3,17,11,10 );
        ParkingTicket ticket1 = new ParkingTicket(vehicle, startDateTime, endDateTime);

        //
        //When
        //
        String outPut = service.printTicket(ticket1);
        String expectedOutPut = "- véhicule : moto essence\n- temps passé : 1h00\n- montant dû : 2 euro(s)";

        //
        //Then
        //
        assertThat(outPut).isEqualTo(expectedOutPut);
    }

    @Test
    public void printing_ticket_between_two_times_different_days() {
        //
        //Given
        //
        Vehicle vehicle = new Vehicle(VehicleType.TWOWHEELES, FuelType.GASOLINE);
        LocalDateTime startDateTime = LocalDateTime.of(2019,3,17,10,10 );
        LocalDateTime endDateTime = LocalDateTime.of(2019,3,18,10,10 );
        ParkingTicket ticket1 = new ParkingTicket(vehicle, startDateTime, endDateTime);

        //
        //When
        //
        String outPut = service.printTicket(ticket1);
        String expectedOutPut = "- véhicule : moto essence\n- temps passé : 24h00\n- montant dû : 25 euro(s)";

        //
        //Then
        //
        assertThat(outPut).isEqualTo(expectedOutPut);
    }

}
