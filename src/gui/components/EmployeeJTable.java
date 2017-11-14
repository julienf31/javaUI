package gui.components;

import javax.swing.*;

public class EmployeeJTable extends JTable{

    //JTable personnalisé
    public EmployeeJTable(EmployeeTabModel model) {
        super(model);


        //Réglage de la taille minimale des colonnes
        this.getColumnModel().getColumn(0).setMinWidth(50);
        this.getColumnModel().getColumn(1).setMinWidth(50);
        this.getColumnModel().getColumn(2).setMinWidth(30);
        this.getColumnModel().getColumn(3).setMinWidth(100);
        this.getColumnModel().getColumn(4).setMinWidth(100);
        this.getColumnModel().getColumn(5).setMinWidth(100);

    }
}
