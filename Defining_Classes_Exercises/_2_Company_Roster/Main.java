package Defining_Classes_Exercises._2_Company_Roster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departmentMap = new HashMap<>();

        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] employeeInfo = scanner.nextLine().split("\\s+");

            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];
            Employee employee = null;

            switch (employeeInfo.length) {

                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 6:
                    String email = employeeInfo[4];
                    int age = Integer.parseInt(employeeInfo[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
                case 5:
                    if (employeeInfo[4].matches("\\d+")) {
                        int personAge = Integer.parseInt(employeeInfo[4]);
                        employee = new Employee(name, salary, position, department, personAge);

                    } else {
                        String personEmail = employeeInfo[4];
                        employee = new Employee(name, salary, position, department, personEmail);
                    }
                    break;
            }
            departmentMap.putIfAbsent(department, new Department(department));
            departmentMap.get(department).getEmployeeList().add(employee);

            employeeList.add(employee);

        }

        Department highestPaidDepartment = departmentMap.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().averageSalary()))
                .get()
                .getValue();

        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());

        highestPaidDepartment.getEmployeeList().stream()
                .sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()))
                .forEach(System.out::println);



    }
}
