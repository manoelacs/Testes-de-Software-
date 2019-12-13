package br.ufal.ic.teste.atividade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TicketDBManagerTest {
    private TicketDBManager tbdm;
    @BeforeEach
    public void start(){
        tbdm = new TicketDBManager();
    }
    @Test
    public void listaTickets() throws IOException {
       Ticket t1 = new Ticket(0, 1, 0L, 0L, 0L);
       Ticket t2 = new Ticket(0, 1, 0L, 0L, 0L);
       Ticket t3 = new Ticket(0, 2, 0L, 0L, 0L);
       List<Ticket> LT = tbdm.getTickets(1);
       List<Ticket> LT2 = null;
       LT2.add(t1);
       LT2.add(t2);
       assertNotNull(LT);
       assertThat(LT, is(equalTo(LT2)));
    }

}
