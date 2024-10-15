package org.example.Labbook2.package_Q3.service;

import org.example.Labbook2.package_Q3.bean.Employee;

public interface EmployeeService {
    void getEmployeeDetails(Employee employee);
    String findInsuranceScheme(Employee employee);
}
