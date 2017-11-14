package gui;

import gui.domain.*;
import gui.service.Personnel;
import gui.view.*;
import gui.models.EmployeeModel;

import javax.swing.*;

import java.util.List;

import static javax.swing.SwingUtilities.invokeLater;

public class Application {
    public static void main(String[] args) {
        invokeLater(Application::window);
    }

    public static void window() {

        EmployeeModel employeeModel = new EmployeeModel();
        Personnel p = new Personnel();

        p.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 30000));
        p.ajouterEmploye(new Representant("Léon", "Vendtout", 25, "2001", 20000));
        p.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000));
        p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, "1998", 45));
        p.ajouterEmploye(new TechnARisque("Jean", "Flippe", 28, "2000", 1000));
        //p.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, "2001", 45));

        ViewManager frame = new ViewManager("App");

        Dashboard dash = new Dashboard(frame);

        ListEmployee liste = new ListEmployee(frame, employeeModel.getPersonnel());

        AddEmployeeController add = new AddEmployeeController(new AddEmployee(frame), employeeModel);


    }

}