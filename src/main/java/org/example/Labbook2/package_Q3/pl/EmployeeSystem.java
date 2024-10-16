package org.example.Labbook2.package_Q3.pl;

import org.example.Labbook2.package_Q3.bean.Employee;
import org.example.Labbook2.package_Q3.service.EmployeeService;
import org.example.Labbook2.package_Q3.service.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeService service = new EmployeeServiceImpl();
        System.out.println("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter Employee Designation: ");
        String designation = scanner.nextLine();

        Employee employee = new Employee(id, name, salary, designation);

        service.getEmployeeDetails(employee);
        System.out.println("Insurance Scheme: " + service.findInsuranceScheme(employee));
        scanner.close();
    }
}