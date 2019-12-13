package br.ufal.ic.teste.atividade;
import br.ufal.ic.teste.atividade.Ticket.*;

import org.junit.jupiter.api.*;

import javax.validation.constraints.Null;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class TicketTest {
    private Ticket t1, t2, t3;
    private Address address;
    public long minutosSegudos(int minutos){
       return  (long)(minutos * 60 * 1000);
    }
    private Ticket ticket;
    @BeforeEach
    public void start(){
         t1 = new Ticket(1, 1, 0L, 10000L, 1500L);
         t2 = new Ticket( 4, 2, 300L, 400L, 50000L);
         address = new Address("57072090");
         t3 = new Ticket( 10, 4, 3, 0L, minutosSegudos(1), minutosSegudos(3), minutosSegudos(7), minutosSegudos(4), minutosSegudos(9),  3.5, 0.0,
        3.5, address);
    }
    @Test
    public void ticketIsNotNull(){

        Ticket ticket=  new Ticket(2, 1, 300L,(long)(5 * 60 * 1000) , (long)(7 * 60 * 1000));
        assertNotNull(ticket);
        assertNotEquals(t1, t2);
    }
    @Test
    public void getNumberTest(){
        assertAll(
                ()-> assertThat(t1.getNumber(), is(1)),
                ()-> assertThat((t1.getNumber()), is(not(t2.getNumber()))),
                ()-> assertThat(t3.getNumber(), is(2)),
                ()-> assertThat(t2.getNumber(), is(not(0)))
        );

    }
    @Test
    public void getAdressTest(){
        assertAll(
                ()-> assertNotNull(t3),
                ()->assertThat(t3.getAddress(), is(address))  ,
                ()-> assertNull(t2.getAddress())
        );
        t2.setAddress(address);
        assertThat(address, is(t2.getAddress()));

    }
    @Test
    public void getEcleticaIdTest(){
        assertAll(
                ()->assertThat(t3.getEcleticaId(), is(10)),
                ()-> assertNull(t1.getEcleticaId()),
                ()-> assertNull(t2.getEcleticaId())
        );
        t1.setEcleticaId(2);
        t2.setEcleticaId(5);
        assertThat(2, is(equalTo(t1.getEcleticaId())));
        assertThat(5, is(equalTo(t2.getEcleticaId())));

    }





}
