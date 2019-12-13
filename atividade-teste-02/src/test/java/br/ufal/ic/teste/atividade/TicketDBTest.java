package br.ufal.ic.teste.atividade;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TicketDBTest {
    private TicketDB ticketDB;

    @BeforeEach
    void start() {
        ticketDB = new TicketDB(1);
    }


    @Test
    void AddVariosTicketsMesmoNumero(){
        Ticket t1  = new Ticket();
        Ticket t2  = new Ticket();

        while (100){
            ticketDB.update( new Ticket(0, 1, 0L, 0L, 0L));
        }
       /* t1 = new Ticket(0, 1, 0L, 0L, 0L);
        ticketDB.update(t1);*/
        t2 = new Ticket( 0, 1, 0L, 0L, 0L);

        ticketDB.update(t2);
        List<Ticket> lt = ticketDB.getTickets();

    }

    @Test
    void getAddressTest() {
        Ticket ticket = new Ticket();
        ticketDB.update(ticket);
        Address address = ticketDB.getAddress("maria", "0000000000", "57072090");
        Address address2 = ticketDB.getAddress("maria","0000000000", "57072090");
        Address address3 = ticketDB.getAddress("","0000000000", "57072090");
        assertAll(
                () -> assertEquals(address, address2),
                () -> assertNotEquals(address, address3)

        );


    }
}
