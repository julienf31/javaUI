package gui.components;

import gui.domain.Employee;
import gui.service.Personnel;

import javax.swing.table.AbstractTableModel;

public class EmployeeTab extends AbstractTableModel{

    private final Personnel personnel;
    private final String[] entetes = {"Nom", "Prénom", "Age", "Date d'entrée", "Unité de calcul"};

    public EmployeeTab(Personnel p) {

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
                return personnel.getEmployee(rowIndex).getAge();
            case 4:
                return personnel.getEmployee(rowIndex).getUnit();
            default:
                return null;
        }
    }
}
