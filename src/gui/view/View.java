package gui.view;

import javax.swing.*;
public abstract class View extends JPanel{
    protected ViewManager frame;

    public View(ViewManager frame) {
        super();
        this.frame = frame;
    }

    public abstract void display();
}
