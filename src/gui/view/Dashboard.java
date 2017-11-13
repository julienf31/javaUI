package gui.view;

import gui.components.DashboardAddButton;
import gui.components.DashboardListButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JPanel{

    ViewManager frame;

    JButton goToList = new DashboardListButton();
    JButton goToAdd = new DashboardAddButton();
    JLabel title = new JLabel("Gestion des employés");

    public Dashboard(ViewManager frame) {
        super();
        this.frame = frame;
        this.frame.addView(this);
        title.setFont(new Font("Helvetica",Font.BOLD,22));

        this.add(title);
        this.add(goToAdd);
        this.add(goToList);
        goToList.addActionListener(this::listButtonPressed);
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

    private void listButtonPressed(ActionEvent actionEvent) {
        frame.setContentPane(frame.Views.get(1));
        frame.revalidate();
        frame.pack();
    }


}
