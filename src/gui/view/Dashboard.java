package gui.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JPanel{

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
        goToAdd.addActionListener(this::goToAdd);
        frame.setContentPane(frame.Views.get(0));
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    private void goToAdd(ActionEvent actionEvent) {
        frame.setContentPane(frame.Views.get(2));
        frame.revalidate();
        frame.pack();
    }

    private void doStuff(ActionEvent actionEvent) {
        frame.setContentPane(frame.Views.get(1));
        frame.revalidate();
        frame.pack();
    }


}
