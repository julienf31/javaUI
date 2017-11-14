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
        //this.view.addSubmitListener(new AddEmployeeListener());
        //this.view.addReturnListener(new AddReturnListener());
        //this.view.addSelectJobListener(new SelectJobListener());
    }

    private class AddReturnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.frame.setContentPane(view.frame.Views.get(0));
            view.frame.revalidate();
            view.frame.pack();
            view.frame.setVisible(true);
            view.frame.setLocationRelativeTo(null);
        }
    }

    public void addEmployee(String name, String surname, String age, String entryDate, String job, String calculBase) {

            System.out.println("CLICK");
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
            view.frame.setContentPane(view.frame.Views.get(0));
            view.frame.revalidate();
            view.frame.pack();
            view.frame.setVisible(true);
            view.frame.setLocationRelativeTo(null);

    }

    private class SelectJobListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (view.getJob()){
                case "Vendeur":
                    view.setHelpLabel("Pour le vendeur, il faut renseigner le chiffre d'affaire du mois");
                    break;
                case "Représentant":
                    view.setHelpLabel("Pour le Représentant, il faut renseigner le chiffre d'affaire du mois");
                    break;
                case "Technicien":
                    view.setHelpLabel("Pour le Technicien, il faut renseigner le nombre d'unités produite");
                    break;
                case "Technicien à Risques":
                    view.setHelpLabel("Pour le Technicien à Risque, il faut renseigner le nombre d'unités produite");
                    break;
                case "Manutentionnaire":
                    view.setHelpLabel("Pour le Manutentionnaire, il faut renseigner le nombre d'heure travailées dans le mois");
                    break;
                case "Manutentionnaire à Risques":
                    view.setHelpLabel("Pour le Manutentionnaire à Risque, il faut renseigner le nombre d'heure travailées dans le mois");
                    break;
            }
        }
    }
}
