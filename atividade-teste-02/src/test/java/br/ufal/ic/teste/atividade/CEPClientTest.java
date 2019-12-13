package br.ufal.ic.teste.atividade;
import org.json.JSONObject;
import org.skyscreamer.jsonassert;

import org.junit.jupiter.api.Test;

import java.net.URL;

public class CEPClientTest {
    CEPClient client = new CEPClient();
    @Test
    public void getAddressTest(){
        JSONObject data =  getRESTData("/friends/367.json");
        String expected = "{friends:[{id:123,name:\"Corby Page\"}"
                + ",{id:456,name:\"Solomon Duskis\"}]}";
        JSONAssert.assertEquals(expected, data, false);


    }
    @Test
    public void cepWebBuscarTest(){
        url = new URL(
                "http://cep.republicavirtual.com.br/web_cep.php?cep=" + toSearch.getCep() + "&formato=xml");
        client.getDocumento();

    }
    @Test
    public void getDocumento(){

    }



}
