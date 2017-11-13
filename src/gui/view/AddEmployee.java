package gui.view;

import gui.components.AddEmployeeSubmitButton;
import gui.components.ReturnButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

public class AddEmployee extends JPanel {
    public ViewManager frame;
    String [] jobs = {
            "Vendeur",
            "Représentant",
            "Technicien",
            "Technicien à Risques",
            "Manutentionnaire",
            "Manutentionnaire à Risques"
    };

    JLabel pageTitle = new JLabel("Ajouter un employé");

    JLabel labelName = new JLabel("Nom : ");
    JTextField textName = new JTextField(20);

    JLabel labelSurname = new JLabel("Prénom: ");
    JTextField textSurname = new JTextField(20);

    JLabel labelAge = new JLabel("Age: ");
    JTextField textAge = new JTextField(6);

    JLabel labelEntryDate = new JLabel("Date d'entrée: ");
    JTextField textEntryDate = new JTextField(6);

    JLabel labelJob = new JLabel("Sélectionnez le poste : ");
    JComboBox<String>  listJob = new JComboBox<>(jobs);

    JLabel labelCalcul = new JLabel("Base de calcul");
    JTextField textCalcul = new JTextField(9);
    JLabel labelHelp = new JLabel();

    JButton goBackButton = new ReturnButton();
    JButton sendButton = new AddEmployeeSubmitButton();

    public AddEmployee(ViewManager frame) {
        super();
        this.frame = frame;
        initView();
        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void initView(){
        frame.setTitle("Gestion des employés - Ajouter un employé");
        this.frame.addView(this);

        pageTitle.setFont(new Font("Helvetica", Font.BOLD, 22));
        labelHelp.setFont(new Font("Helvetica", Font.ITALIC,8));

        Box l1 = Box.createHorizontalBox();
        l1.add(pageTitle,BorderLayout.PAGE_START);

        Box l2 = Box.createHorizontalBox();
        l2.add(labelName);
        l2.add(textName);

        Box l3 = Box.createHorizontalBox();
        l3.add(labelSurname);
        l3.add(textSurname);

        Box l4 = Box.createHorizontalBox();
        l4.add(labelAge);
        l4.add(textAge);

        Box l5 = Box.createHorizontalBox();
        l5.add(labelEntryDate);
        l5.add(textEntryDate);

        Box l6 = Box.createHorizontalBox();
        l6.add(labelJob);
        l6.add(listJob);

        Box l7 = Box.createHorizontalBox();
        l7.add(labelCalcul);
        l7.add(textCalcul);

        Box l8 = Box.createHorizontalBox();
        l8.add(labelHelp);

        Box l9 = Box.createHorizontalBox();
        l9.add(goBackButton);
        l9.add(sendButton);

        Box box = Box.createVerticalBox();
        box.add(l1);
        box.add(l2);
        box.add(l3);
        box.add(l4);
        box.add(l5);
        box.add(l6);
        box.add(l7);
        box.add(l8);
        box.add(l9);

        this.add(box);
    }


    //récupération de tout les champs

    public String getName(){
        return textName.getText();
    }

    public String getSurname(){
        return textSurname.getText();
    }

    public String getEntryDate(){
        return textEntryDate.getText();
    }

    public String getAge(){
        return textAge.getText();
    }

    public String getJob(){
        return listJob.getSelectedItem().toString(); // utiliser les objet pour apres
    }

    public String getCalculBase(){
        return textCalcul.getText();
    }

    public void setHelpLabel(String label){
        labelHelp.setText(label);
    }

    public void addSubmitListener(ActionListener clickOnSendButton){
        sendButton.addActionListener(clickOnSendButton);
    }

    public void addReturnListener(ActionListener clickOnReturnButton){
        goBackButton.addActionListener(clickOnReturnButton);
    }

    public void addSelectJobListener(ActionListener selectJob){
        listJob.addActionListener(selectJob);
    }

}
