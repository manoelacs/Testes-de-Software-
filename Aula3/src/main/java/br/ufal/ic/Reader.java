package br.ufal.ic;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Reader {
    public static  String readAll(Path path){
        String texto = "";
        try{
            FileInputStream fin = new FileInputStream(String.valueOf(path));
            int i=fin.read();
            int size = fin.available();

            while ( i !=-1){
               texto =  texto.concat(String.valueOf((char) i));
              //  System.out.print(String.valueOf((char) i));
                i=fin.read();
            }
           // System.out.print(texto);
            fin.close();
        } catch(Exception e){System.out.println(e);}
        return texto;
    }

    public static void main(String args[]){
        Path path = Paths.get("C:\\Users\\aleon\\IdeaProjects\\Aula3\\documentos_teste\\teste1.txt");
        //readAll(path);
        System.out.println( readAll(path));
    }

}
