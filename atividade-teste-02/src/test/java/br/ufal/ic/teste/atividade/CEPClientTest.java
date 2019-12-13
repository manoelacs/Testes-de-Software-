package br.ufal.ic.teste.atividade;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert;

import org.junit.jupiter.api.Test;

public class CEPClientTest {
    CEPClient client = new CEPClient();
    @Test
    public void getAddressTest(){
        JSONObject data =  getRESTData("/friends/367.json");
        String expected = "{friends:[{id:123,name:\"Corby Page\"}"
                + ",{id:456,name:\"Solomon Duskis\"}]}";
        JSONAssert.assertEquals(expected, data, false);


    }



}
