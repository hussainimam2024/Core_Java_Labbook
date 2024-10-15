package org.example.Labbook2.package_Q3.pl;

import org.example.Labbook2.package_Q3.bean.Employee;
import org.example.Labbook2.package_Q3.service.EmployeeService;
import org.example.Labbook2.package_Q3.service.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeService service = new EmployeeServiceImpl();

        // Get employee details from user
        System.out.println("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter Employee Designation: ");
        String designation = scanner.nextLine();

        // Create employee object
        Employee employee = new Employee(id, name, salary, designation);

        // Display employee details
        service.getEmployeeDetails(employee);

        // Display the insurance scheme
        System.out.println("Insurance Scheme: " + service.findInsuranceScheme(employee));

        scanner.close();
    }
}