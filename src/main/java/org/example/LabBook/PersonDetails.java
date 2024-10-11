package org.example.LabBook;

import java.util.Scanner;

public class PersonDetails {
    public static String Person_details(String firstName, String lastName, int age, String gender, String phone) {
        return "Name: " + firstName + " " + lastName + "\nAge: " + age + "\nGender: " + gender + "\nPhone: " + phone;
    }
    public static void display(String personDetails) {
        System.out.println("Here is the Person Details ");
        System.out.println(personDetails);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("please enter your first name: ");
        String firstName = sc.nextLine();

        System.out.print("please enter your last name: ");
        String lastName = sc.nextLine();

        System.out.print("please enter your age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("please enter your gender: ");
        String gender = sc.nextLine();

        System.out.print("please enter your phone number: ");
        String phone = sc.nextLine();
        PersonDetails obj1 = new PersonDetails();

        String personInfo = obj1.Person_details(firstName, lastName, age, gender, phone);
        obj1.display(personInfo);
    }
}
