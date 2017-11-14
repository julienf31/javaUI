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
    JButton goBack = new JButton("Retour");

    JLabel salaryLabel;

    public ListEmployee(ViewManager frame, Personnel p) {
        super();

        this.setLayout(new BorderLayout());

        this.personnel = p;
        this.frame = frame;
        this.frame.addView(this);

        EmployeeJTable PersonnelTab = new EmployeeJTable(new EmployeeTabModel(p));
        this.add(new JScrollPane(PersonnelTab), BorderLayout.NORTH);

        JPanel buttons = new JPanel();
        buttons.add(goBack);
        goBack.addActionListener(this::goBack);

        this.add(buttons, BorderLayout.SOUTH);

        this.salaryLabel = new JLabel ("",JLabel.CENTER);
        this.add(salaryLabel, BorderLayout.CENTER);

        updateSalary();

        this.frame.setVisible(true);
        this.frame.pack();

    }

    private void goBack(ActionEvent actionEvent) {
        frame.Views.get(0).display();
        frame.revalidate();
        frame.pack();
    }

    public void display(){
        frame.setTitle("List des employés");
        this.frame.setContentPane(this);
        frame.revalidate();
        //frame.setSize(500, 700);
        frame.pack();
        updateSalary();
        this.frame.setLocationRelativeTo(null);
    }

    public void updateSalary(){
        salaryLabel.setText("Salaire moyen : " + personnel.getTruncSalaireMoyen() + " €");
    }
}
