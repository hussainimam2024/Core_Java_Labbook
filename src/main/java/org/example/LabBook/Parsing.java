package org.example.LabBook;

public class Parsing {
    public static void main(String[] args) {
        String val = "1234";
        int number = Integer.parseInt(val);
        int i = (int)(100/7);
        float c = (float)(100/7);

        System.out.println("The addition with string is:"+ (val+1000));
        System.out.println("the addition with number is:"+(number+1000));
        System.out.println(i);
        System.out.println(c);
    }
}
