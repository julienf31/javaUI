package gui.service;

import gui.domain.Employee;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Personnel {

    private List<Employee> employees;
    private static final String PRINT_PATTERN = "%s gagne %.2f euros";
    private List<JPanel> Views = new ArrayList<>();

    public Personnel() {
        this.employees = new ArrayList<>();
    }

    public void ajouterEmploye(Employee employee) {
        this.employees.add(employee);
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

    public void addView(JPanel view){
        this.Views.add(view);
    }

    public int getLength (){
        return employees.size();
    }

    public Employee getEmployee(int index){
        return employees.get(index);
    }
}
