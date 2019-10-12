package br.ufal.ic;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {

        @Test
        public void test01(){
            Path path1 = Paths.get("C:\\Users\\aleon\\IdeaProjects\\Aula3\\documentos_teste\\teste1.txt");
            Path path2 = Paths.get("C:\\Users\\aleon\\IdeaProjects\\Aula3\\documentos_teste\\teste2.txt");
            String s1 = "teste1, teste1";
            String s2 = "teste 2, funcionando";
            assertEquals(s1, Reader.readAll(path1));
            assertAll(
                    () -> assertEquals(s1, Reader.readAll(path1)),
                    ()-> {
                        assertEquals(s2, Reader.readAll(path2));
                    });


        }
}
