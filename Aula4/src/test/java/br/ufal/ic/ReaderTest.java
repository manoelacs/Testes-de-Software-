package br.ufal.ic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReaderTest {
    private final Reader reader = new Reader();

    private final static String loremIpsum = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

    @BeforeAll
    static void createFile() {
        try (Writer writer =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream("myFile.txt"), StandardCharsets.UTF_8
                             )
                     )
        ) {
            writer.write(loremIpsum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void textIsCorret() throws FileNotFoundException {
        //Reader r = new InputStreamReader(new FileInputStream("src\\test\\resources\\teste.txt"));
        String resultado = reader.readAll("src\\test\\resources\\teste.txt");
       // myFile.txt
        //src\test\resources\teste.txt
        assertEquals(loremIpsum, resultado);
    }
    @Test
    void fileDoesNotExist() {
        String resultado = reader.readAll("src\\test\\resources\\nothing.txt");
        assertNull(resultado);
    }
    @Test
    void fileMaiorque4096() throws IOException {
        FileInputStream fin = new FileInputStream(String.valueOf("src\\test\\resources\\teste2.txt"));
        int s = fin.read();
        String resultado = reader.readAll("src\\test\\resources\\teste2.txt");
        assertEquals(resultado.length(), s);

    }
}




