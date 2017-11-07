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
        frame.setContentPane(frame.Views.get(0));
        frame.pack();
        frame.setVisible(true);
    }

    private void doStuff(ActionEvent actionEvent) {
        frame.setContentPane(frame.Views.get(1));
        frame.revalidate();
    }


}
