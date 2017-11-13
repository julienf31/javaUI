package gui.view;

import gui.service.Personnel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewManager extends JFrame {

    public List<JPanel> Views = new ArrayList<>();
    private Personnel personnel;

    public ViewManager(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addView (JPanel view){
        Views.add(view);
    }
}
