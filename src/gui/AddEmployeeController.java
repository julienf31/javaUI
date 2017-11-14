package gui;

import gui.domain.*;
import gui.models.EmployeeModel;
import gui.view.AddEmployee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeeController {
    private AddEmployee view;
    private EmployeeModel model;

    public AddEmployeeController(EmployeeModel employeeModel) {
        this.model = employeeModel;
        System.out.println(model.toString());
    }

    public void addEmployee(String name, String surname, String age, String entryDate, String job, String calculBase) {
            try{
                int ageInt = Integer.parseInt(age);
                double calculBaseDouble = Double.parseDouble(age);

                //création de l'employé correspondant
                switch(job){
                    case "Vendeur":
                        System.out.println("CREATION D'UN VENDEUR");
                        model.ajouterEmploye(new Vendeur(name,surname,ageInt,entryDate,calculBaseDouble));
                        break;
                    case "Représentant":
                        System.out.println("CREATION D'UN REPRESENTANT");
                        model.ajouterEmploye(new Representant(name,surname,ageInt,entryDate,calculBaseDouble));
                        break;
                    case "Technicien":
                        System.out.println("CREATION D'UN TECHNICIEN");
                        model.ajouterEmploye(new Technicien(name,surname,ageInt,entryDate,calculBaseDouble));
                        break;
                    case "Technicien à Risques":
                        System.out.println("CREATION D'UN TECHNICIEN A RISQUES");
                        model.ajouterEmploye(new TechnARisque(name,surname,ageInt,entryDate,calculBaseDouble));
                        break;
                    case "Manutentionnaire":
                        System.out.println("CREATION D'UN MANUTENTIONNAIRE");
                        model.ajouterEmploye(new Manutentionnaire(name,surname,ageInt,entryDate,calculBaseDouble));
                        break;
                    case "Manutentionnaire à Risques":
                        System.out.println("CREATION D'UN MANUTENTIONNAIRE A RISQUE");
                        model.ajouterEmploye(new ManutARisque(name,surname,ageInt,entryDate,calculBaseDouble));
                }
            }catch(NumberFormatException ex){
                System.out.println("Erreur de conversion :" + ex.getMessage());
            }catch (Exception ex){
                ex.printStackTrace();
            }

    }
}
