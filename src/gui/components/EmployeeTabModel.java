package gui.components;

import gui.service.Personnel;

import javax.swing.table.AbstractTableModel;

//Sert de modèle pour la création du JTable
public class EmployeeTabModel extends AbstractTableModel{

    //Données du tableau -> Objet donc mise à jour auto
    private final Personnel personnel;

    //Titre des colonnes
    private final String[] entetes = {"Nom", "Prénom", "Age", "Date d'entrée", "Unité de calcul", "Salaire"};

    public EmployeeTabModel(Personnel p) {

        super();
        this.personnel = p;

    }

    @Override
    public int getRowCount() {
        return personnel.getLength();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    //Sert à remplir le tableau
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return personnel.getEmployee(rowIndex).getLastname();
            case 1:
                return personnel.getEmployee(rowIndex).getFirstname();
            case 2:
                return personnel.getEmployee(rowIndex).getAge();
            case 3:
                return personnel.getEmployee(rowIndex).getEntryYear();
            case 4:
                return personnel.getEmployee(rowIndex).getUnit();
            case 5:
                return personnel.getEmployee(rowIndex).getTruncSalaire();
            default:
                return null;
        }
    }
}
