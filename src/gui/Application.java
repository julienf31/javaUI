package gui;

import gui.models.EmployeeModel;
import gui.view.AddEmployee;
import gui.view.Dashboard;
import gui.view.ListEmployee;
import gui.view.ViewManager;

import javax.swing.*;

import java.util.List;

import static javax.swing.SwingUtilities.invokeLater;

public class Application {
    public static void main(String[] args) {
        invokeLater(Application::window);
    }

    public static void window() {
        ViewManager frame = new ViewManager("App");

        Dashboard dash = new Dashboard(frame);

        ListEmployee liste = new ListEmployee(frame);

        AddEmployeeController add = new AddEmployeeController(new AddEmployee(frame), new EmployeeModel());


    }

}