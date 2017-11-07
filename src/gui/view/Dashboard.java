package gui.view;

import javax.swing.*;

public class Dashboard {
    public JPanel dashboard = new JPanel();

    JButton goToList = new JButton("Liste des employés");
    JButton goToAdd = new JButton("Ajouyer un employé");

    public Dashboard(JFrame frame) {
        dashboard.add(goToAdd);
        dashboard.add(goToList);

        goToList.addActionListener(e -> System.out.print(1));
        frame.setContentPane(dashboard);
        frame.pack();
        frame.setVisible(true);
    }
}
