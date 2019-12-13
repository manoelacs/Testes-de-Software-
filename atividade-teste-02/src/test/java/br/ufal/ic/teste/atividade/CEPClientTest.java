package br.ufal.ic.teste.atividade;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;



import java.net.URL;

public class CEPClientTest {
    private  CEPClient client ;
    private Address address, address2, address3;


    @BeforeEach
    public void start(){
        client.cepWebBuscar(new Address("57072090"));
         address = new Address();
         address2 = new Address();
    }
    @Test
    public void cepWebBuscarTest(){

            address = new Address("57072090");
            address2 = new Address("57072090");
            address3 = new Address("57070442");

            client.cepWebBuscar(address);
            client.cepWebBuscar(address2);
            client.cepWebBuscar(address3);
            assertEquals(client.getAddress(address),client.getAddress(address2));
            assertNotEquals(client.getAddress(address),client.getAddress(address2));
    }
    @Test
    public void getDocumento(){
        url = new URL(
                "http://cep.republicavirtual.com.br/web_cep.php?cep=" + toSearch.getCep() + "&formato=xml");
        SAXReader reader = new SAXReader();
        Document document1 = reader.read(url);
        Document document2;
        document2 =  client.getDocumento(url);
        assertEquals(document1,document2);

    }


}
