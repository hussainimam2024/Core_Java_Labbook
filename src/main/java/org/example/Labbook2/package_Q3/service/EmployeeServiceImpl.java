package org.example.Labbook2.package_Q3.service;

import org.example.Labbook2.package_Q3.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void getEmployeeDetails(Employee employee) {
        // Display employee details
        System.out.println(employee);
    }

    @Override
    public String findInsuranceScheme(Employee employee) {
        // Returning the insurance scheme based on employee's salary and designation
        return employee.getInsuranceScheme();
    }
}