package gui;

import gui.controller.AddEmployeeController;
import gui.service.Personnel;
import gui.view.*;

import static javax.swing.SwingUtilities.invokeLater;

public class Application {
    public static void main(String[] args) {
        invokeLater(Application::window);
    }

    public static void window() {

        Personnel personnel= new Personnel();

        ViewManager frame = new ViewManager("App");

        Dashboard dash = new Dashboard(frame);

        ListEmployee liste = new ListEmployee(frame, personnel);

        AddEmployee add1 = new AddEmployee(frame, new AddEmployeeController(personnel));

    }

}