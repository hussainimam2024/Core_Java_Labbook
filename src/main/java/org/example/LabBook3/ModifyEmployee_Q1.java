package org.example.LabBook3;

import java.util.Scanner;

class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
public class ModifyEmployee_Q1 {
    private String FirstName;
    private String LastName;
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) throws CustomException {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new CustomException("First name should not be empty.");
        }
        this.FirstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) throws CustomException {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new CustomException("Last name should not be empty.");
        }
        this.LastName = lastName;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ModifyEmployee_Q1 employee = new ModifyEmployee_Q1();
        try {
            System.out.print("Enter first name: ");
            String firstName = sc.nextLine();

            System.out.print("Enter last name: ");
            String lastName = sc.nextLine();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);

            System.out.println("Employee full name: " + employee.getFirstName() + " " + employee.getLastName());
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("something went wrong: " + e.getMessage());
        }
    }
}
