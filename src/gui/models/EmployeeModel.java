package gui.models;

import gui.domain.Employee;
import gui.service.Personnel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class EmployeeModel {

    private Personnel personnel;
    private static final String PRINT_PATTERN = "%s gagne %.2f euros";

    public EmployeeModel() {
        this.personnel = new Personnel();
    }

    public void ajouterEmploye(Employee employee) {
        this.personnel.employees.add(employee);
    }

    public Personnel getPersonnel() {
        return this.personnel;
    }

    public void afficherSalaires() {
        personnel.employees.forEach(employee -> System.out.println(String.format(PRINT_PATTERN, employee.getName(), employee.calculerSalaire())));
    }

    public double salaireMoyen() {
        double total = 0;
        for (Employee employee: this.personnel.employees) {
            total += employee.calculerSalaire();
        }
        return total / this.personnel.employees.size();
    }
}
