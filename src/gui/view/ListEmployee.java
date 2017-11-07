package gui.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ListEmployee extends JPanel{
    ViewManager frame;

    JButton goBack = new JButton("Retour");
    JTable employeeTab = new JTable(new Object[][]{{"Test", "Test", "Test", "Test", "Test", "Test"}, {"Test", "Test", "Test", "Test", "Test", "Test"}}, new String[]{"Nom", "Prénom", "Poste", "Age", "Date d'entrée", "Salaire"});
    JScrollPane scrollPane = new JScrollPane(employeeTab, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);





    public ListEmployee(ViewManager frame) {
        super();
        //BorderLayout layout = new BorderLayout();
        //this.setLayout(layout);
        this.frame = frame;
        this.frame.addView(this);
        scrollPane.setPreferredSize(new Dimension(200, 200));
        this.add(scrollPane);
        this.add(goBack);
        goBack.addActionListener(this::goBack);




        this.frame.setVisible(true);
        this.frame.pack();



    }

    private void goBack(ActionEvent actionEvent) {
        frame.setContentPane(frame.Views.get(0));
        frame.revalidate();
        frame.pack();
    }

    public void displayListEmployee(){
        this.frame.setContentPane(this);
    }
}
