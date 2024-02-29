/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package assignment1;

/**
 * @author Chris Barnbeck
 * Assignment 1
 * 
 * This is an interface for the attendance tracker so we can customize our use
 * of the Tree Map.
 * @since 01/28/2023
 * I have followed the UNCG Academic Integrity policy on this
 * assignment.
 */
public interface Tracker {

    public void display();

    public void add(Employee newEmployee);

    public void search(String id);

}
