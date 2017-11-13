package gui.view;

import gui.components.EmployeeJTable;
import gui.components.EmployeeTabModel;
import gui.domain.ManutARisque;
import gui.service.Personnel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.BiPredicate;

public class ListEmployee extends View{
    ViewManager frame;

    Personnel personnel;
    JButton goBack = new JButton("Retour");
    JButton test = new JButton("Ajouter");
    JTable employeeTab = new JTable(new Object[][]{{"Test", "Test", "Test", "Test", "Test", "Test"}, {"Test", "Test", "Test", "Test", "Test", "Test"}}, new String[]{"Nom", "Prénom", "Poste", "Age", "Date d'entrée", "Salaire"});
    //JScrollPane scrollPane = new JScrollPane(employeeTab, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    JLabel salaryLabel;





    public ListEmployee(ViewManager frame, Personnel p) {
        super();

        this.setLayout(new BorderLayout());

        this.personnel = p;
        //BorderLayout layout = new BorderLayout();
        //this.setLayout(layout);
        this.frame = frame;
        this.frame.addView(this);
        //this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        
        //scrollPane.setPreferredSize(new Dimension(200, 200));
        //this.add(scrollPane);

        EmployeeJTable PersonnelTab = new EmployeeJTable(new EmployeeTabModel(p));

        this.add(new JScrollPane(PersonnelTab), BorderLayout.NORTH);

        JPanel buttons = new JPanel();
        buttons.add(goBack);
        goBack.addActionListener(this::goBack);

        this.salaryLabel = new JLabel ("",JLabel.CENTER);
        updateSalary();
        this.add(salaryLabel, BorderLayout.CENTER);

        //test ajout dynamique
        buttons.add(test);
        test.addActionListener(this::ajouter);

        this.add(buttons, BorderLayout.SOUTH);




        this.frame.setVisible(true);
        this.frame.pack();




    }

    private void goBack(ActionEvent actionEvent) {

        frame.setContentPane(frame.Views.get(0));
        frame.revalidate();
        frame.pack();
    }


    private void ajouter(ActionEvent actionEvent){

        personnel.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, "2001", 45));

    }

    public void display(){
        frame.setTitle("List des employés");
        this.frame.setContentPane(this);
        frame.revalidate();
        frame.setSize(700, 900);
        updateSalary();
    }

    public void updateSalary(){
        salaryLabel.setText("Salaire moyen : " + personnel.getTruncSalaireMoyen() + " €");
    }
}
