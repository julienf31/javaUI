package gui.controller;

import gui.domain.*;
import gui.service.Personnel;

public class AddEmployeeController {
    private Personnel model;

    public AddEmployeeController(Personnel model) {
        this.model = model;
        System.out.println(model.toString());
    }

    public void addEmployee(String name, String surname, String age, String entryDate, String job, String calculBase) {
            try{
                //conversion en int et double des valeures nécessaires
                int ageInt = Integer.parseInt(age);
                double calculBaseDouble = Double.parseDouble(age);

                //création de l'employé en fonction de la selection
                switch(job){
                    case "Vendeur":
                        System.out.println("Création du vendeur " + name + " " + surname);
                        model.ajouterEmploye(new Vendeur(name,surname,ageInt,entryDate,calculBaseDouble));
                        break;
                    case "Représentant":
                        System.out.println("Création du représentant "+ name + " " + surname);
                        model.ajouterEmploye(new Representant(name,surname,ageInt,entryDate,calculBaseDouble));
                        break;
                    case "Technicien":
                        System.out.println("Création du technicien "+ name + " " + surname);
                        model.ajouterEmploye(new Technicien(name,surname,ageInt,entryDate,calculBaseDouble));
                        break;
                    case "Technicien à Risques":
                        System.out.println("Création du technicien à risque "+ name + " " + surname);
                        model.ajouterEmploye(new TechnARisque(name,surname,ageInt,entryDate,calculBaseDouble));
                        break;
                    case "Manutentionnaire":
                        System.out.println("Création du manutentionnaire "+ name + " " + surname);
                        model.ajouterEmploye(new Manutentionnaire(name,surname,ageInt,entryDate,calculBaseDouble));
                        break;
                    case "Manutentionnaire à Risques":
                        System.out.println("Création du manutentionnaire à risques "+ name + " " + surname);
                        model.ajouterEmploye(new ManutARisque(name,surname,ageInt,entryDate,calculBaseDouble));
                    default:
                        System.err.println("Erreur de selection");
                }
            }catch(NumberFormatException ex){
                // si erreur de conversion
                System.err.println("Erreur de conversion sur le champ age ou base de calcul:" + ex.getMessage());
            }catch (Exception ex){
                ex.printStackTrace();
            }

    }
}
