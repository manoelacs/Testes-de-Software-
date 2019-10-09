package br.ufal.ic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {


    public static List<String> ex01(List<String> list) {

        List<String> primeiraLetra = list.stream().map(s -> s.substring(0, 1)).collect(Collectors.toList());

        return primeiraLetra;
    }

    public static List<String> ex02(List<String> list) {

        List<String> vogais = Arrays.asList("a", "e", "i", "o", "u");
        List<String> primeiraLetra = list.stream().map(s -> s.substring(0, 1)).filter(vogais::contains).collect(Collectors.toList());
         return primeiraLetra;
    }
    public static List<String> ex03( List<String> list){

        List<String> tamanhoPar = list.stream().filter(s -> (s.length() % 2) != 0).collect(Collectors.toList());
       // tamanhoPar.forEach(System.out::println);
        return tamanhoPar;
    }
    public static void ex04(){
        new Thread(()-> {
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            list.forEach(System.out::println);
        }).start();
    }
    public static List<String> ex05(List<String> list){
        List<String> listLowercase = list.stream().map(s->s.toLowerCase()).collect(Collectors.toList());
        //listLowercase.forEach(System.out::println);
        return listLowercase;
    }
    public static String ex06(List<String> list){

        String f = IntStream.range(0,4).mapToObj(list::get).collect(Collectors.joining("_"));
        //System.out.println(f);
        return f;
    }
}
