package gui.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Dashboard extends View{

    ViewManager frame;

    JLabel title = new JLabel("Gestion des employés");
    JButton goToList = new JButton("Liste des employés");
    JButton goToAdd = new JButton("Ajouyer un employé");

    public Dashboard(ViewManager frame) {
        super();
        this.frame = frame;
        this.frame.addView(this);
        title.setFont(new Font("Helvetica",Font.BOLD,22));

        this.add(title);
        this.add(goToAdd);
        this.add(goToList);

        goToList.addActionListener(this::goToList);
        goToAdd.addActionListener(this::goToAdd);
        this.display();
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    private void goToAdd(ActionEvent actionEvent) {
        frame.Views.get(2).display();
    }

    private void goToList(ActionEvent actionEvent) {
        frame.Views.get(1).display();
    }

    public void display(){
        frame.setTitle("Gestionnaire d'employés");
        this.frame.setContentPane(this);
        frame.revalidate();
        frame.pack();
        this.frame.setLocationRelativeTo(null);
    }


}
