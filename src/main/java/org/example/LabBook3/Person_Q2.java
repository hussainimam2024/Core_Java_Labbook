package org.example.LabBook3;


import java.util.Scanner;

class ImamException extends RuntimeException {
    public ImamException(String message) {
        super(message);
    }
}
public class Person_Q2 {
    private String name;
    private int age;

    public void setName(String Name){
        this.name = Name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) throws ImamException {
        if (age <= 15) {
            throw new ImamException("Age must be above 15. Invalid age: " + age);
        }
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Person_Q2 person = new Person_Q2();
            System.out.println("Enter the name of the person: ");
            String name = sc.nextLine();
            System.out.println("Enter the age of the person: ");
            int age = sc.nextInt();
            person.setName(name);
            person.setAge(age);

            System.out.println(person.getName() + " is " + person.getAge() + " years old.");
        } catch (ImamException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

