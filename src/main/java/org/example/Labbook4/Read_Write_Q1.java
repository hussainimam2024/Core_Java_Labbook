package org.example.Labbook4;

import java.io.*;

public class Read_Write_Q1 {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\imam.hussain\\OneDrive - ascendion\\Documents\\sample.txt";
        try {
            String content = readFile(filePath);
            String reversedContent = new StringBuilder(content).reverse().toString();
            writeFile(filePath, reversedContent);
            System.out.println("Content reversed and written back");
        } catch (IOException e) {
            System.out.println("error occurred: " + e.getMessage());
        }
    }
    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (Reader reader = new FileReader(filePath)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                content.append((char) ch);
            }
        }
        return content.toString();
    }
    public static void writeFile(String filePath, String content) throws IOException {
        try (Writer writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }
}

