package org.example.Labbook2.package_Q3.bean;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String designation;
    private String insuranceScheme;

    public Employee(int id, String name, double salary, String designation) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        this.insuranceScheme = determineInsuranceScheme();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
        this.insuranceScheme = determineInsuranceScheme();
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
        this.insuranceScheme = determineInsuranceScheme();
    }

    public String getInsuranceScheme() {
        return insuranceScheme;
    }

    // Private method to determine the insurance scheme
    private String determineInsuranceScheme() {
        if (salary >= 50000 && designation.equalsIgnoreCase("Manager")) {
            return "Elite Star health scheme";
        } else if (salary >= 30000 && designation.equalsIgnoreCase("Programmer")) {
            return "Pro Star health scheme";
        } else if (salary >= 20000 && designation.equalsIgnoreCase("System Engineer")) {
            return "Basic coverage scheme";
        } else {
            return "your salary is not enough to get an insurance scheme";
        }
    }
    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Salary=" + salary +
                ", Designation=" + designation + ", InsuranceScheme=" + insuranceScheme + "]";
    }
}
