/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1;

/**
 * @author Chris Barnbeck 
 * Assignment 1
 *
 * This is an Employee object that takes an ID, a name, and annual salary as
 * parameters.
 * @since 01/28/2023
 * I have followed the UNCG Academic Integrity policy on this
 * assignment.
 */
public class Employee {

    private String employeeID;
    private String firstName;
    private String lastName;
    private double salary;

    /**
     * Employee constructor
     *
     * @param employeeID is unique employee ID
     * @param firstName is the employee first name
     * @param lastName is the employee last name
     * @param salary is the employee annual salary as a double
     */
    public Employee(String employeeID, String firstName, String lastName, double salary) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * This method returns employee details as a string.
     *
     * @return employee PII as a string
     */
    @Override
    public String toString() {
        return "employee{" + "employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + '}';
    }

}
