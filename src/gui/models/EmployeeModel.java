package gui.models;

import gui.domain.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class EmployeeModel {

    private List<Employee> employees;
    private static final String PRINT_PATTERN = "%s gagne %.2f euros";

    public EmployeeModel() {
        this.employees = new ArrayList<>();
    }

    public void ajouterEmploye(Employee employee) {
        this.employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void afficherSalaires() {
        employees.forEach(employee -> System.out.println(String.format(PRINT_PATTERN, employee.getName(), employee.calculerSalaire())));
    }

    public double salaireMoyen() {
        double total = 0;
        for (Employee employee: employees) {
            total += employee.calculerSalaire();
        }
        return total / employees.size();
    }
}
