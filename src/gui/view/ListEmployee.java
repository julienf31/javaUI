package gui.view;

import javax.swing.*;

public class ListEmployee {
    JPanel list = new JPanel();
    JFrame frame;

    JButton goBack = new JButton("");

    public ListEmployee(JFrame frame) {
        this.frame = frame;
        list.add(goBack);
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public void displayListEmployee(){
        this.frame.setContentPane(list);
    }
}
