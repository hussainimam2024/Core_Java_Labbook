package org.example.Basicjava.ExceptionHandling;

import java.util.*;
class AgeException extends Exception {
    private int age;

    AgeException(int a) {
        age = a;
    }
    public AgeException(String s) {
        super(s);
    }
}
class emp {
    String name;
    int age;
    void getDetails() throws AgeException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        name = sc.nextLine();
        System.out.println("Enter your age:");
        age = sc.nextInt();
        if (age < 16) {
            throw new AgeException(age+" age is invalid");
        }
    }
}
public class Custom_Exception {
    public static void main(String[] args) {
        try {
            emp e = new emp();
            e.getDetails();
        } catch (AgeException e) {
            System.out.println(e.getMessage());
        }

    }
}