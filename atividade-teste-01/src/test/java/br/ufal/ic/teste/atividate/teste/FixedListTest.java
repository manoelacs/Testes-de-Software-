package br.ufal.ic.teste.atividate.teste;
import br.ufal.ic.teste.atividate.teste.FixedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FixedListTest {
    private static FixedList<Integer> fl = null;
    @BeforeEach
    void resetfl() {
        List<Integer> list = null;

        fl = FixedList.fixedList(list);

    }
    @Test
    void testAdd(){
        Integer mockValue = 3;
        assertFalse(fl.contains(mockValue));
        fl.add(mockValue);
        assertTrue(fl.contains(mockValue));
    }
    @Test
    void testAddAll(){
        List<Integer> mockValues = Arrays.asList(5, 3);
        fl.addAll(mockValues);
        assertTrue(fl.contains(2));
        assertTrue(fl.contains(3));


    }
    @Test
    void testClear(){
        List<Integer> mockValues = Arrays.asList(5, 3);
        fl.addAll(mockValues);
        assertTrue(fl.contains(5));
        assertTrue(fl.contains(3));
        fl.clear();
        assertFalse(fl.contains(5) && fl.contains(3));
    }
    //lastIndexOf tem a mesma funcionalidade do IndexOf
    @Test
    void testIndexOf(){
        List<Integer> mockValues = Arrays.asList(5, 3,3);
        fl.addAll(mockValues);
        assertTrue(2 == fl.indexOf(3));
    }
    @Test
    void testGet(){
        List<Integer> mockValues = Arrays.asList(5, 3,3);
        fl.addAll(mockValues);
        assertTrue(3 == fl.get(1));
    }
    @Test
    void testIteratiior(){
        FixedList<String> fls = null;
        fls.add("A");
        fls.add("B");
        fls.add("C");
        fls.add("D");
        // Iterator


        // ListIterator
        assertTrue( fls.listIterator().equals("B"));

    }
    @Test
    void testRemove(){
        fl.add(4);
        fl.add(3);
        assertTrue(fl.contains(3));
        fl.remove(3);
        assertFalse(fl.contains(3));
    }
    @Test
    void testSet(){

    }
    @Test
    void testSubList(){
        List<String> sub = null;
        List<String> oraculo = Arrays.asList("A", "B");
        FixedList<String> fls = null;
        fls.add("A");
        fls.add("B");
        fls.add("C");
        fls.add("D");
        sub = fls.subList(0,1);
        assertEquals(sub, oraculo);
    }
    //contains
    @Test
    void testContains(){
        Integer mockValue = 2;
        assertFalse(fl.contains(mockValue));
        fl.add(mockValue);
        assertTrue(fl.contains(mockValue));
    }
    // isEmpty()
   @Test
    void testIsEmpty(){


   }
    //size()
    @Test
    void testSize(){
        List<Integer> mockValues = Arrays.asList(5, 3,3);
        assertTrue(3 == fl.size());

    }
    //toArray(final T[] object)
    @Test
    void testToArray(){

    }
    //containsAll(final Collection<?> coll)
    @Test
    void testContaisAll(){
        List<Integer> mockValues = Arrays.asList(5, 3,3);
        fl.addAll(mockValues);
        assertTrue(fl.containsAll(mockValues));

    }
    //toString()
    @Test
    void testToString(){

    }
    //equals(final Object object)
    @Test
    void testEquals(){
        FixedList<String> fls = null;
        fls.add("A");
        fls.add("B");
        FixedList<String> fls2 = null;
        fls2.add("A");
        fls2.add("B");
        assertTrue(fls.equals(fls2));


    }
    //hashCode()
    @Test
    void testHashCode(){

    }
    /**
     * List iterator that only permits changes via set()
     */
    @Test
    void testIterator(){
       // FixedListIterator fli = new <>FixedListIterator();
        List<Integer> mockValues = Arrays.asList(5, 3,3);
        fl.addAll(mockValues);
       // hasNext()
        assertAll(() -> assertTrue(fl.iterator().hasNext()),
                () -> assertEquals(3, fl.iterator().next())

                );


    }
}
