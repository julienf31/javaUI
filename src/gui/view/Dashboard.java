package gui.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends View{

    ViewManager frame;

    JButton goToList = new JButton("Liste des employés");
    JButton goToAdd = new JButton("Ajouyer un employé");

    public Dashboard(ViewManager frame) {
        super();
        this.frame = frame;
        this.frame.addView(this);
        this.add(goToAdd);
        this.add(goToList);

        goToList.addActionListener(this::doStuff);
        this.display();
        frame.pack();
        frame.setVisible(true);
    }

    private void doStuff(ActionEvent actionEvent) {
        frame.Views.get(1).display();
    }

    public void display(){
        frame.setTitle("Gestionnaire d'employés");
        this.frame.setContentPane(this);
        frame.revalidate();
        frame.pack();

    }


}
