package com.excilys.parking.console;

import com.excilys.parking.core.model.Car;
import com.excilys.parking.core.model.Client;
import com.excilys.parking.core.model.ParkingTicket;
import org.junit.Test;

import java.time.LocalTime;
import static org.assertj.core.api.Assertions.assertThat;

public class PrintTicketTest {
    @Test
    public void mapToUser_with_non_null_dto_should_return_User_mapped_field_by_field() {
        PrintTicket printTicket = new PrintTicket();
        Client client1 = new Client(Car.TWOWHEELES);
        LocalTime startTime = LocalTime.of(10,0);
        LocalTime endTime = LocalTime.of(11,46);
        ParkingTicket ticket1 = new ParkingTicket(client1, startTime, endTime);
        String expectedOutPut = "- véhicule : voiture essence\n- temps passé : 1h46\n- montant dû : 2 euro(s)";
        assertThat(printTicket.printTicket(ticket1)).isEqualTo(expectedOutPut);
    }

}
