/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1;

import java.util.Scanner;

/**
 * @author Chris Barnbeck
 * Assignment 1
 * 
 * This object is the main menu of the program.
 * @since 01/28/2023
 * I have followed the UNCG Academic Integrity policy on this
 * assignment.
 */
public class Menu {

    /**
     * This method runs the menu.
     *
     */
    public void runMenu() {
        int userSelection;
        Scanner sc = new Scanner(System.in);

        //Relative path assigned and menu started in loop
        while (true) {
            String path = "/Users/cbarnbeck/Desktop/CSC 330/Assignment1/src/assignment1/employee.txt";
            Attendance report = new Attendance(path);
            System.out.println("1. Display: Display all employees in list in easy to read tabular format.");
            System.out.println("2. Add Employee: Get employee information from user and add to the Map.");
            System.out.println("3. Search: Get EmployeeID input from the user and display the employee if they exist.");
            System.out.println("0. Exit: Exit the menu.");

            System.out.printf("\nEnter a command: ");
            userSelection = sc.nextInt();

            switch (userSelection) {

                //Display Attendance Report
                case 1:
                    report.display();
                    break;

                //Add employee to Attendance Report.
                case 2:
                    String employeeID;
                    String firstName;
                    String lastName;
                    double salary;
                    System.out.printf("\nEnter Employee ID: ");
                    employeeID = sc.next();
                    System.out.printf("\nEnter Employee First Name: ");
                    firstName = sc.next();
                    System.out.printf("\nEnter Employee Last Name: ");
                    lastName = sc.next();
                    System.out.printf("\nEnter Employee Salary: ");
                    salary = sc.nextDouble();
                    Employee newEmployee = new Employee(employeeID, firstName, lastName, salary);
                    report.add(newEmployee);
                    break;

                //Search for an employee by their ID
                case 3:
                    System.out.printf("\nEnter Employee ID: ");
                    employeeID = sc.next();
                    report.search(employeeID);
                    break;

                //Exit program
                case 0:
                    System.exit(0);

                //Handles invalid entries
                default:
                    System.out.println("Invalid user input! Please make a valid choice. \n");

            }
        }

    }

}
