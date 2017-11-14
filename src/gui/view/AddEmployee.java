package gui.view;

import gui.controller.AddEmployeeController;
import gui.components.AddEmployeeSubmitButton;
import gui.components.ReturnButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.*;

public class AddEmployee extends View {

    protected AddEmployeeController controller;

    //liste de job pour le JSelect
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

    public AddEmployee(ViewManager frame, AddEmployeeController controller) {
        super(frame);
        this.controller = controller;
        this.frame = frame;
        this.initView();
    }

    private void initView(){
        this.frame.addView(this);

        pageTitle.setFont(new Font("Helvetica", Font.BOLD, 22));
        labelHelp.setFont(new Font("Helvetica", Font.ITALIC,8));

        sendButton.addActionListener(this::sendData);
        goBackButton.addActionListener(this::goBack);
        listJob.addActionListener(this::displayHelpLabel);

        //utilisation du Layout BOX plus simple pour afficher le formulaire
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


        //ajout des box à une boite verticale (dans l'ordre d'affichage)
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

        //affichage du layout
        this.add(box);
    }

    //fonction d'envoi de data à la validation
    private void sendData(ActionEvent actionEvent) {
        this.controller.addEmployee(getName(), getSurname(), getAge(), getEntryDate(),getJob(), getCalculBase());
        this.emptyTextField(); // on vide les champs de texte
        this.frame.Views.get(1).display(); // go to list view
    }

    private void goBack(ActionEvent actionEvent){
        this.frame.Views.get(0).display();
    }

    //fonction de récupération des champs

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
        return listJob.getSelectedItem().toString();
    }

    public String getCalculBase(){
        return textCalcul.getText();
    }

    //modification du help label
    public void setHelpLabel(String label){
        labelHelp.setText(label);
    }

    public void displayHelpLabel(ActionEvent e) {
        switch (getJob()){
            case "Vendeur":
                setHelpLabel("Pour le vendeur, il faut renseigner le chiffre d'affaire du mois");
                break;
            case "Représentant":
                setHelpLabel("Pour le Représentant, il faut renseigner le chiffre d'affaire du mois");
                break;
            case "Technicien":
                setHelpLabel("Pour le Technicien, il faut renseigner le nombre d'unités produite");
                break;
            case "Technicien à Risques":
                setHelpLabel("Pour le Technicien à Risque, il faut renseigner le nombre d'unités produite");
                break;
            case "Manutentionnaire":
                setHelpLabel("Pour le Manutentionnaire, il faut renseigner le nombre d'heure travailées dans le mois");
                break;
            case "Manutentionnaire à Risques":
                setHelpLabel("Pour le Manutentionnaire à Risque, il faut renseigner le nombre d'heure travailées dans le mois");
                break;
        }
        this.frame.pack();
    }

    //remise à zéro des champs aprés la création de l'employé
    public void emptyTextField(){
        this.textSurname.setText("");
        this.textName.setText("");
        this.textAge.setText("");
        this.textCalcul.setText("");
        this.textEntryDate.setText("");
        this.listJob.setSelectedIndex(0);
    }

    //fonction d'affichage de la vue
    public void display(){
        this.frame.setTitle("Ajouter un employé");
        this.frame.setContentPane(this);
        this.frame.revalidate();
        this.frame.setLocationRelativeTo(null);
        this.frame.pack();
    }
}
