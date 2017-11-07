package gui;

import gui.view.Dashboard;
import gui.view.ListEmployee;

import javax.swing.*;

import java.util.List;

import static javax.swing.SwingUtilities.invokeLater;

public class Application {
    public static void main(String[] args) {
        invokeLater(Application::window);
    }

    public static void window() {
        JFrame frame = new JFrame("App");

        Dashboard dash = new Dashboard(frame);
        ListEmployee liste = new ListEmployee(frame);
        
        frame.setContentPane(dash.dashboard);

    }

}