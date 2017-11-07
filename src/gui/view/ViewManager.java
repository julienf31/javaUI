package gui.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewManager extends JFrame {

    public List<JPanel> Views = new ArrayList<>();

    public ViewManager(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addView (JPanel view){
        Views.add(view);
    }
}
