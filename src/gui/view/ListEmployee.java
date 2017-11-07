package gui.view;

import javax.swing.*;

public class ListEmployee extends JPanel{
    ViewManager frame;

    JButton goBack = new JButton("Starfoullah");

    public ListEmployee(ViewManager frame) {
        super();
        this.frame = frame;
        this.frame.addView(this);
        this.add(goBack);
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public void displayListEmployee(){
        this.frame.setContentPane(this);
    }
}
