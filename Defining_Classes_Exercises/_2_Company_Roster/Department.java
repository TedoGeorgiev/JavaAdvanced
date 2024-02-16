package Defining_Classes_Exercises._2_Company_Roster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department (String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public double averageSalary () {
        return employeeList.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployees(List<Employee> employees) {
        this.employeeList = employees;
    }

}
