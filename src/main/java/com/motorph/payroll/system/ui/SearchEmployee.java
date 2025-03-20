/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.ui;
import com.motorph.payroll.system.models.*;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author djjus
 */
public class SearchEmployee {
    private Scanner scanner;
    private ArrayList<Employee> employee;
    
    public SearchEmployee(Scanner scanner, ArrayList<Employee> employee){
        this.scanner = scanner;
        this.employee = employee;
    }
    
    public void display() {
        while(true) {
            System.out.println("""
                               *************************************
                                          Search Employee
                               *************************************
                               [1] Search by Employee Number
                               [2] Search by Last Name 
                               [3] Go back to Main Screen
                               Enter a number: """);
            
            int choice = scanner.nextInt();
            if (choice == 3) {
                break;
            }
            
            switch(choice) {
                case 1:
                    searchNum();
                    break;
                
                case 2:
                    searchLast();
                    break;
                    
                default:
                    System.out.println("Invalid Number. Choose only from 1 - 3");
            }
            
            
        } 
    }
    
    public void searchNum() {
        while(true) {
            System.out.println("Enter Employee Number:(Enter 1 to go back)");
            
            int choice = scanner.nextInt();
            if (choice == 1) {
                break;
            }
            
            String print = resultTemplate(findEmployee(choice));
            System.out.println(print);

        }
    }
    
    public void searchLast() {
        while(true) { 
            System.out.println("Enter Employee Last Name:(Enter 1 to to go back)");
            String choice = scanner.next();
            
            if (choice.equals("1")) {
                break;
            }
            
            String print = resultTemplate(findEmployee(choice));
            System.out.println(print);
            
            
        }
    }
    
    
    public String findEmployee(int choice) {
        String result = "No record found.";
        for (Employee emp : this.employee) {
            if (emp.getId().equals(String.valueOf(choice))){
                result = emp.toString();
                break;
            }
        }
        return result;
    }
    
    public String findEmployee(String choice) {
        String result = "No record found.";
        for (Employee emp : this.employee) {
            if (emp.getLastName().toLowerCase().equals(choice.toLowerCase())){
                result = emp.toString();
                break;
            }
        }
        
        return result;
    }
    
    private String resultTemplate(String result){
        return "*************************************" + 
                "\n" + result + 
                "\n*************************************";
    }
}
