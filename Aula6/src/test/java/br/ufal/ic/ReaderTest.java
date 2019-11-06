package br.ufal.ic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
/**
 *
 * @author Janderson
 */

public class ReaderTest {
    private Reader reader;

    private final static String loremIpsum = "Lorem Ipsum";

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

    @BeforeEach
    public void setUp() {
        reader = new Reader();
    }

    @Test
    void textIsCorrect() {
        String result = reader.readAll("myFile.txt");
        assertEquals(loremIpsum, result);
    }

    @Test
    void textIsIOException() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("myFile.txt");
        String result = reader.readAll(fis);
        assertEquals(loremIpsum, result);

        result = reader.readAll(fis);
        assertEquals(loremIpsum, result);
    }

    @Test
    void test4KB() {
        String text = reader.readAll(
                "src/test/resources/test.txt");

        assertEquals(14275, text.length());
    }

    @Test
    void fileDoesNotExist() {
        String result = reader.readAll("nothing.txt");
        assertNull(result);
    }

    @Test
    void testRead() throws FileNotFoundException {

        String result = reader.readAll(
                new MockFileInputStream("myFile.txt"));
        assertEquals(loremIpsum, result);
    }

    @Test
    void testClose() throws FileNotFoundException {

        MockFileInputStream fis =
                new MockFileInputStream("myFile.txt");

        String result = reader.readAll(fis);

        assertTrue(fis.isClosed);
    }

    public class MockFileInputStream extends FileInputStream {

        private boolean isClosed = false;

        public MockFileInputStream(String name) throws FileNotFoundException {
            super(name);
        }

        @Override
        public int read(byte[] buff) throws IOException {

            int size = super.read(buff);

            return size - 5;
        }

    }
}
