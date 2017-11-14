package gui.view;

import gui.components.EmployeeJTable;
import gui.components.EmployeeTabModel;
import gui.service.Personnel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ListEmployee extends View{
    ViewManager frame;
    Personnel personnel;

    //Composants
    JPanel buttons;
    JButton goBack;
    JLabel salaryLabel;
    JScrollPane tabScrollPane;

    public ListEmployee(ViewManager frame, Personnel p) {
        super();

        //Définition du layout
        this.setLayout(new BorderLayout());

        this.personnel = p;
        this.frame = frame;
        this.frame.addView(this);

        //Ajout du tableau
        //Création du tableau avec le modèle
        EmployeeJTable PersonnelTab = new EmployeeJTable(new EmployeeTabModel(p));
        //Création du scrollpane avec le tableau
        this.tabScrollPane = new JScrollPane(PersonnelTab);
        this.add(tabScrollPane, BorderLayout.NORTH);

        //Ajout du bouton
        this.goBack = new JButton("Retour");
        this.goBack.addActionListener(this::goBack);

        //Ajout d'un pannel de bouton (facultatif mais utile pour gérer plusieurs boutons)
        this.buttons = new JPanel();
        this.buttons.add(goBack);
        this.add(buttons, BorderLayout.SOUTH);

        //Ajout du label pour affichage du salaire
        this.salaryLabel = new JLabel ("",JLabel.CENTER);
        this.add(salaryLabel, BorderLayout.CENTER);

        //Mise à jour du salaire
        updateSalary();

        this.frame.setVisible(true);

    }

    //AL du bouton GoBack
    private void goBack(ActionEvent actionEvent) {
        this.frame.Views.get(0).display();
        this.frame.revalidate();
        this.frame.pack();
    }


    //Actualisation du label
    public void updateSalary(){
        this.salaryLabel.setText("Salaire moyen : " + personnel.getTruncSalaireMoyen() + " €");
    }

    //Fonction appellée lors de l'affichage de la vue
    public void display(){

        //Mise à jour du Label du salaire à l'affichage
        updateSalary();

        this.frame.setTitle("Liste des employés");
        this.frame.setContentPane(this);
        this.frame.revalidate();
        this.frame.setLocationRelativeTo(null);
        this.frame.pack();


    }
}
