package br.ufal.ic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Janderson
 */

public class Reader {
    /**
     * This method reads a text file from a specified path
     * and returns it as a String.
     * It must use FileInputStream
     *
     * @param path relative path to a text file to be read
     * @return text file as string
     */
    public String readAll(String path) {
        try {
            File file = new File(path);

            return readAll(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String readAll(FileInputStream fis) {
        byte[] buffer = new byte[4096];
        try {
            int size = fis.read(buffer);
            System.out.println("size: " + size);

            byte[] auxBuffer = new byte[size];
            System.arraycopy(buffer, 0, auxBuffer, 0, size);
            return new String(auxBuffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//        	fis.close();
//        }
        return null;
    }
}
