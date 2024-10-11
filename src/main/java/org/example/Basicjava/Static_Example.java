package org.example.Basicjava;

public class Static_Example {
    static int num1 = 2;
    static int num2 = 3;

    static {
        System.out.println("this is static block");
        num2 = num1 * 4;
    }

    static void mymethod(int num3) {
        System.out.println("Number1:"+ num1);
        System.out.println("Number2:"+ num2);
        System.out.println("Number3:"+ num3);
    }

    public static void main(String[] args) {
        mymethod(500);
    }
}