import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class java8 {
    /*## Exercício 1
    1. Utilizar a seguinte lista: List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
    2. Mapear para uma lista de String com apenas a primeira letra
    3. Imprimir cada letra dessa lista*/
    public static void ex1(){
        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
       // List<String> primeiraLetra = list.stream().map(s -> s.substring(0,1)).collect(Collectors.toList());
        list.stream().map(s -> s.substring(0,1)).forEach(System.out::println);
    }
    /*## Exercício 2

    1. Utilizar a seguinte lista: List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
    2. Mapear para uma lista de String com apenas a primeira letra
    3. Filtrar para incluir apenas as vogais
    4. Imprimir cada letra da lista filtrada*/
    public static void ex2(){
        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
        List<String> vogais = Arrays.asList("a", "e", "i", "o", "u");
        List<String> primeiraLetra = list.stream().map(s -> s.substring(0,1)).collect(Collectors.toList());
        primeiraLetra.stream().filter(vogais::contains).forEach(System.out::println);
    }
    /*## Exercício 3

1. Utilizar a seguinte lista: List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
2. Remover os items com tamanho (quantidade de lebtras) par
3. Imprimir a lista remanescente*/
    public static void ex3(){
        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
        List<String> tamanhoPar = list.stream().filter(s -> (s.length() % 2) != 0).collect(Collectors.toList());
        tamanhoPar.forEach(System.out::println);
    }
/*## Exercício 4

1. Utilizar a seguinte lista: List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
2. Criar uma nova thread que imprime os números dessa lista*/
public static void ex4(){
    new Thread(()-> {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.forEach(System.out::println);
    }).start();
}

    /*## Exercício 5

1. Utilizar a seguinte lista: List<String> list = Arrays.asList("The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");
2. Criar uma nova lista com todas as strings da lista original convertida em minúsculas
3. Imprimir essa nova lista*/

    public static void ex5(){
        List<String> list = Arrays.asList("The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");
        List<String> listLowercase = list.stream().map(s->s.toLowerCase()).collect(Collectors.toList());
        listLowercase.forEach(System.out::println);
    }
    /*## Exercício 6

1. Utilizar a seguinte lista: List<String> list = Arrays.asList("The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");
2. Juntar a segunda, terceira e quarta strings da lista em uma única seqüência, onde cada palavra é separada por um hífen (-).
3. Imprimir a string resultante.*/
    public static void ex6(){
        List<String> list = Arrays.asList("The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");
        String f = IntStream.range(0,4).mapToObj(list::get).collect(Collectors.joining("_"));
        System.out.println(f);
    }

    public static void main(String[] args){
        //ex1();
        //ex2();
        //ex3();
       // ex4();
       // ex5();
        ex6();
    }
}

