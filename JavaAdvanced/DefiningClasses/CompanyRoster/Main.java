package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> employees = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employees.putIfAbsent(department, new ArrayList<>());
                employees.get(department).add(new Employee(name, salary, position, department, email, age));
            } else if (tokens.length == 5) {
                if (Character.isDigit(tokens[4].charAt(0))) {
                    int age = Integer.parseInt(tokens[4]);
                    employees.putIfAbsent(department, new ArrayList<>());
                    employees.get(department).add(new Employee(name, salary, position, department, age));
                } else {
                    String email = tokens[4];
                    employees.putIfAbsent(department, new ArrayList<>());
                    employees.get(department).add(new Employee(name, salary, position, department, email));
                }
            } else if (tokens.length == 4) {
                employees.putIfAbsent(department, new ArrayList<>());
                employees.get(department).add(new Employee(name, salary, position, department));
            }
        }

        employees.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    List<Employee> value1 = e1.getValue();
                    List<Employee> value2 = e2.getValue();

                    double firstAverageSalary = 0.0;
                    for (Employee employee : value1) {
                        firstAverageSalary += employee.getSalary();
                    }
                    firstAverageSalary /= value1.size();

                    double secondAverageSalary = 0.0;
                    for (Employee employee : value2) {
                        secondAverageSalary += employee.getSalary();
                    }
                    secondAverageSalary /= value2.size();

                    return Double.compare(secondAverageSalary, firstAverageSalary);
                })
                .limit(1)
                .forEach(d -> {
                    System.out.println("Highest Average Salary: " + d.getKey());
                    List<Employee> departmentEmployees = d.getValue();
                    departmentEmployees.stream()
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(e -> System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
                });
    }
}
