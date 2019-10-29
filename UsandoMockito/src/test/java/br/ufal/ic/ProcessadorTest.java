package br.ufal.ic;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ProcessadorTest {
    @Mock
    FonteOrigem fonteOrigem = null;
    @Mock
    FonteDestino fonteDestino = null;

    @Before
    public void inicializa() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testProcessaDados()
    {

        Mockito.when(fonteOrigem.leDados()).thenReturn("DadoTeste");


        Processador processador = new Processador(fonteOrigem, fonteDestino);

        try {

            processador.processaDados();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(fonteOrigem, Mockito.times(1)).leDados();
        Mockito.verify(fonteDestino, Mockito.times(1)).gravaDados("DadoTeste");

    }
}
