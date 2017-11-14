package gui;

import gui.controller.AddEmployeeController;
import gui.service.Personnel;
import gui.view.*;

import static javax.swing.SwingUtilities.invokeLater;

public class Application {
    public static void main(String[] args) {
        invokeLater(Application::window);
    }

    public static void window() {

        //Création du Modèle de données
        Personnel personnel= new Personnel();

        //Création de la fenetre
        ViewManager frame = new ViewManager("App");

        //Création de la vue principale
        Dashboard dash = new Dashboard(frame);

        //Création de la vue liste d'employées
        ListEmployee liste = new ListEmployee(frame, personnel);

        //Création du controleur lié à la vue d'ajout
        AddEmployeeController addControler = new AddEmployeeController(personnel);

        //Création de la vue d'ajout
        AddEmployee add1 = new AddEmployee(frame, addControler);



    }

}