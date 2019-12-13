package br.ic.ufal;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class HancrestTest {
    //* dois arrays são iguais
    @Test
    void arraysIguais(){
        int[] a = {12,32,54,6,8,89,64,64,6};
        int[] b = {12,32,54,6,8,89,64,64,6};
        assertThat(a, equalTo(b));
    }
    //* dois objetos são diferentes
    @Test
    void objetosDiferentes(){
        Entidade a = new Entidade("ana");
        Entidade b = new Entidade("jose");
        assertThat(a, not(equalTo(b)));
    }
    //* dois objetos são iguais
    @Test
    void objetosIguais(){
        Entidade a = new Entidade("ana");
        Entidade b = new Entidade("ana");
        assertThat(a, is(b));
    }
    //* que a string ("computação") contém as substrings "o" e "ta"
    @Test
    void stringTest_01(){
        String s = "computação";

        assertThat(s,  allOf(containsString("o"), containsString("ta")));
    }
    //* que uma lista ("um", "dois", "três", "quatro") tem pelo menos os itens ("dois" e "quatro")
    @Test
    void listTest(){
        List<String> a = Arrays.asList("um", "dois", "três", "quatro");

        assertThat(a, hasItems("dois", "quatro"));
    }
    //* a string "computação" é igual a string "computação" e que ela inicia com "comput"
    @Test
    void stringTest_02(){
        String s = "computação";

        assertThat(s, allOf(is("computação"), startsWith("comput")));
    }
    //* a string "instituto" não é igual "matemática" nem "física"
    @Test
    void stringTest_03(){
        String s = "instituto";

        assertThat(s, allOf(not(is("computação")), not(is("física"))));
    }
    //* a string "instituto" é igual a "matemática" ou a "instituto"
    @Test
    void stringTest_04(){
        String s = "instituto";

        assertThat(s, anyOf( (is("matemática")),(is( "instituto"))));
    }
    //* que 7 não é igual nem a 3 nem a 4
    @Test
    void numeroTest(){
        int sete = 7;

        assertThat(sete, allOf( not(is(4)), not(is(3))));
    }
    //* obj1 = new Object() não é a mesma instância de obj2 = new Object()
    @Test
    void objetoTest(){
        Entidade a = new Entidade("ana");
        Entidade b = new Entidade("jose");

        assertThat(a , not(sameInstance(b)));
    }
    //* que todos os itens de uma lista tem a letra "a"
    @Test
    void listTest_02(){
        List<String> list = Arrays.asList("ana", "maria", "alice", "dani");

     assertThat(list, everyItem(containsString("a")));

    }

}
