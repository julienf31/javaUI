package gui;

import gui.domain.*;
import gui.service.Personnel;
import gui.view.*;
import gui.models.EmployeeModel;

import javax.swing.*;

import java.util.List;

import static javax.swing.SwingUtilities.invokeLater;

public class Application {
    public static void main(String[] args) {
        invokeLater(Application::window);
    }

    public static void window() {

        EmployeeModel employeeModel = new EmployeeModel();

        ViewManager frame = new ViewManager("App");

        Dashboard dash = new Dashboard(frame);

        ListEmployee liste = new ListEmployee(frame, employeeModel.getPersonnel());

        AddEmployee add1 = new AddEmployee(frame, new AddEmployeeController(employeeModel));

        //AddEmployeeController add = new AddEmployeeController(new AddEmployee(frame), employeeModel);


    }

}