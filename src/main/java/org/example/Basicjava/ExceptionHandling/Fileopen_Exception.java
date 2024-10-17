package org.example.Basicjava.ExceptionHandling;
import java.io.File;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Fileopen_Exception {
    public static void main(String[] args) throws IOException {

        File file = new File("file.txt");
        FileReader fr = new FileReader(file);
        System.out.println(fr.read());
        fr.close();
    }
}

