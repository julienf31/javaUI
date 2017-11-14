package gui.service;

import gui.domain.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Personnel {

    public List<Employee> employees;
    private static final String PRINT_PATTERN = "%s gagne %.2f euros";
    private List<JPanel> Views = new ArrayList<>();

    public Personnel() {
        this.employees = new ArrayList<>();
        this.init();
    }

    public void ajouterEmploye(Employee employee) {
        this.employees.add(employee);
    }

    public void init(){
        this.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 30000));
        this.ajouterEmploye(new Representant("Léon", "Vendtout", 25, "2001", 20000));
        this.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000));
        this.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, "1998", 45));
        this.ajouterEmploye(new TechnARisque("Jean", "Flippe", 28, "2000", 1000));
        this.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, "2001", 45));
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

    public String getTruncSalaireMoyen(){
        return String.format("%.2f", this.salaireMoyen());
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
