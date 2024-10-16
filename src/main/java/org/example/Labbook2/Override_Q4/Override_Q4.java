package org.example.Labbook2.Override_Q4;

import org.example.Labbook2.package_Q3.bean.Employee;

// Interface
public interface Override_Q4 {
    void getEmployeeDetails(Employee employee);
    String findInsuranceScheme(Employee employee);
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

