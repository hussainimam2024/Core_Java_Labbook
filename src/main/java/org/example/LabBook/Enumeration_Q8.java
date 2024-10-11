package org.example.LabBook;

import java.util.Scanner;
/*
Q8
Modify the above program, to accept only ‘M’ or ‘F’ as gender field values.
Use Enumeration for implementing the same.
*/

public class Enumeration_Q8 {
    public static String Person_details(String firstName, String lastName, int age, Gender gender, String phone) {
        return "Name: " + firstName + " " + lastName + "\nAge: " + age + "\nGender: " + gender + "\nPhone: " + phone;
    }

    enum Gender {
        M, F;
    }

    public static void display(String personDetails) {
        System.out.println("person details:");
        System.out.println(personDetails);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("first name: ");
        String firstName = sc.nextLine();

        System.out.print("last name: ");
        String lastName = sc.nextLine();

        System.out.print("your age: ");
        int age = sc.nextInt();
        sc.nextLine();

        Gender gender = null;
        while (gender == null) {
            System.out.print("your gender M or F : ");
            String genderInput = sc.nextLine().toUpperCase();

            try {
                gender = Gender.valueOf(genderInput);
            } catch (Exception e) {
                System.out.println("Only Female and Male is allowed here");
            }
        }
        System.out.print("your phone number: ");
        String phone = sc.nextLine();

        String personInfo = Person_details(firstName, lastName, age, gender, phone);
        display(personInfo);
    }
}
