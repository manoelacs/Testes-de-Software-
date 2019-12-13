package br.ufal.ic.teste.atividade;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.junit.jupiter.api.Assertions.*;


import javax.validation.constraints.AssertTrue;
import java.net.URL;

public class CEPClientTest {
    private  CEPClient client ;

    @BeforeEach
    public void start(){
        client.cepWebBuscar(new Address("57072090"));
        Address address = new Address();
        Address address2 = new Address();
    }
    @Test
    public void cepWebBuscarTest(){

            address = new Address("57072090")
            address2 = new Address("57072090")
            Address address3 = new Address("57070442");

            client.cepWebBuscar(addrees);
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
