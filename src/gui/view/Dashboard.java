package gui.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Dashboard extends View{

    private JLabel title = new JLabel("Gestion des employés");
    private JButton goToList = new JButton("Liste des employés");
    private JButton goToAdd = new JButton("Ajouyer un employé");
    private JLabel copyright = new JLabel("Copyright © Phalien Fourneau");

    public Dashboard(ViewManager frame) {
        super(frame);
        this.frame = frame;
        this.frame.addView(this);
        title.setFont(new Font("Helvetica",Font.BOLD,22));

        Box b1 = Box.createHorizontalBox();
        b1.add(title);

        Box b2 = Box.createHorizontalBox();
        b2.add(goToAdd);
        b2.add(goToList);

        Box b3 = Box.createHorizontalBox();
        b3.add(copyright);

        Box b4 = Box.createVerticalBox();
        b4.add(b1);
        b4.add(b2);
        b4.add(b3);

        goToList.addActionListener(this::goToList);
        goToAdd.addActionListener(this::goToAdd);

        this.add(b4);
        this.display();

    }

    //ActionListener du boutton vers ajout
    private void goToAdd(ActionEvent actionEvent) {
        frame.Views.get(2).display();
    }
    //ActionListener du boutton vers liste
    private void goToList(ActionEvent actionEvent) {
        frame.Views.get(1).display();
    }

    //Fonction d'affichage de cette vue
    public void display(){
        frame.setTitle("Gestionnaire d'employés");
        this.frame.setContentPane(this);
        frame.revalidate();
        frame.pack();
        this.frame.setLocationRelativeTo(null);
    }
}
