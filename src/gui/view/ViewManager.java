package gui.view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ViewManager extends JFrame {

    //Liste de toutes les vues de l'application
    public List<View> Views = new ArrayList<>();

    //Constructeur simple
    public ViewManager(String title) {
        super(title);

        //On quitte le programme à la fermeture de la fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addView (View view){
        Views.add(view);
    }
}
