/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Chris Barnbeck 
 * Assignment 1
 *
 * This object represents an Attendance Tracker that makes use of a Tree Map to
 * store CSV values a user can manipulate.
 * @since 01/28/2023 
 * I have followed the UNCG Academic Integrity policy on this
 * assignment.
 */
public class Attendance implements Tracker {

    private String path;

    /**
     *
     * @param path is the path of the employee CSV file specified in the Menu
     * object.
     */
    public Attendance(String path) {
        this.path = path;

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * This method parses a CSV file into a tree map.
     *
     * @return Tree Map that takes an employee ID as a key and a
     * list of Employee objects as values.
     */
    public TreeMap<String, List<Employee>> takeAttendance() {
        File file = new File(path);

        TreeMap<String, List<Employee>> employees = new TreeMap<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                List employeeList = new ArrayList<Employee>();
                //Parse each line into an array to split by delimiter and create new employee object
                String data = sc.nextLine();
                String[] employeeData = data.split(",");
                Employee employeeInfo = new Employee(employeeData[0], employeeData[1].strip(), employeeData[2].strip(), Double.parseDouble(employeeData[3].strip()));
                //Adds duplicate employees to the list so we can keep track of total attendance
                if (employees.containsKey(employeeData[0])) {
                    employees.get(employeeData[0]).add(employeeInfo);
                } else {
                    employeeList.add(employeeInfo);
                    //Insert new employee and list into map
                    employees.put(employeeData[0], employeeList);

                }

            }

            sc.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block

        }

        //Tree map returned
        return employees;

    }

    /**
     * This method displays the map in a tabular form.
     *
     */
    @Override
    public void display() {
        System.out.println("\n");
        for (Map.Entry<String, List<Employee>> entry : takeAttendance().entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("\n");

    }

    /**
     * This method searches for an employee based on employee ID and returns
     * their information if their attendance is being tracked.
     *
     * @param id is the employee ID
     */
    @Override
    public void search(String id) {

        boolean found = false;
        for (Map.Entry<String, List<Employee>> entry : takeAttendance().entrySet()) {
            if (entry.getKey().contains(id)) {
                found = true;
                System.out.println("\n" + entry.getValue() + "\n");
            }

        }
        if (found == false) {
            System.out.println("\n" + "Employee not found." + "\n");
        }
    }

    /**
     * This method adds a new employee to the attendance tracker by appending a
     * new record to the source CSV file to preserve data integrity.
     *
     * @param newEmployee is the employee being added.
     */
    @Override
    public void add(Employee newEmployee) {
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write("\n" + newEmployee.getEmployeeID() + "," + " " + newEmployee.getFirstName() + ",     " + newEmployee.getLastName() + ",  " + newEmployee.getSalary());
            writer.close();
            System.out.println("\nEmployee added succesfully.\n");
        } catch (IOException e) {
            System.out.println("\nError! Employee not added.\n");
        }

    }

}
