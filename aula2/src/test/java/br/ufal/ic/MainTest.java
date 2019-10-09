package br.ufal.ic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MainTest {


    @Test
    public void testEx01() {
        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");

        List<String> oracle = Arrays.asList("a", "b", "c", "d", "e", "f");

        Assertions.assertEquals(oracle, Main.ex01(list));
    }
    @Test
    public void testEx02(){
        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
        List<String> oracle = Arrays.asList("a", "e");
        Assertions.assertEquals(oracle, Main.ex02(list));
    }
    @Test
    public void testEx03(){
        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
        List<String> oracle = Arrays.asList("alpha", "bravo", "charlie", "delta", "foxtrot");
        Assertions.assertEquals(oracle, Main.ex03(list));
    }


    @Test
    public void testEx05(){
        List<String> list = Arrays.asList("The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");
        List <String> oracle = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");
        Assertions.assertEquals(oracle, Main.ex05(list));
    }
    @Test
    public void testEX06(){
        List<String> list = Arrays.asList("The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");
        String oracle = "The_quick_brown_fox";
        Assertions.assertEquals(oracle, Main.ex06(list));
    }

}
