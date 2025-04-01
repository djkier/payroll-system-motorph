/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.ui;
import com.motorph.payroll.system.models.*;
import java.util.Scanner;
import java.util.Map;

/**
 *
 * @author djjus
 */
public class PrintPayslip {
    private Scanner scanner;
    private Map<Integer, Employee> employeeRecords;
    
    public PrintPayslip(Scanner scanner, Map<Integer, Employee> empRec) {
        this.scanner = scanner;
        this.employeeRecords = empRec;
    }
    
    public void display(){
        
        while (true) {
            printPaySlipHeader();
            System.out.println("Enter Employee Number:(Enter 1 to go back)");
            
            if (scanner.hasNextInt()){
                int choice = scanner.nextInt();
                if (choice == 1) {
                    break;
                }
                resultDisplay(choice);
            } else {
                System.out.println("Invalid input. Please enter a number between 1 to 7.");
                scanner.next();
            }            
            
            
        }
        
    }
    
    public void resultDisplay(int choice){
        if(employeeRecords.containsKey(choice)) {
            chooseType(employeeRecords.get(choice));
        } else {
            System.out.println("Employee do not exist.");
        }
    }
    
    public void printPaySlipHeader(){
        System.out.println("""
                            *************************************
                                         Print Payslip
                            *************************************""");
    }
    
    public void printEmpDetails(Employee emp){
        
        System.out.println("Employee Number: " + emp.getId() +
                            "\nEmployee Name: " + emp.getFullName() +
                            "\nAvailable Record: " + emp.availableRecord());        
    }
    
    public void chooseType(Employee emp) {
        boolean exit = false;
        while(!exit) {
            printPaySlipHeader();
            printEmpDetails(emp);
                    
            System.out.println("""
                               How would you like to view the payslip?
                               [1]Full Month/Bi-Month
                               [2]Custom Range
                               [3]Go Back
                               """);
            
            if (scanner.hasNextInt()){
                int choice = scanner.nextInt();
                
                switch(choice) {
                    case 1:
                        chooseMonth(emp);
                        break;
                        
                    case 2:
                        System.out.println("2");
                        break;
                        
                    case 3:
                        exit = true;
                        break;
                    
                    default: 
                        System.out.println("Invalid");
                }
                
            } else {
                System.out.println("Invalid input. Please enter a number between 1 to 3.");
                scanner.next();
            }     
        }
    }
    
    public void chooseMonth(Employee emp){
        boolean exit = false;
        while(!exit) {
            printPaySlipHeader();
            printEmpDetails(emp);
            System.out.println("""
                               Which Month?
                               [1]January           [7]July
                               [2]February          [8]August
                               [3]March             [9]September
                               [4]April             [10]October
                               [5]May               [11]November
                               [6]June              [12]December
                               ----------------------------------
                               Enter [13] to go back:"""); 
            
            if (scanner.hasNextInt()){
                int choice = scanner.nextInt();
                
                if (choice == 13) {
                    exit = true;
                } else if (emp.monthExist(choice)){
                    System.out.println("here");
                } else {
                    noRecord(emp);
                }
                
            } else {
                System.out.println("Invalid input. Please enter a number between 1 to 13.");
                scanner.next();
            }  
        }
    }
    
    public void noRecord(Employee emp){
        while(true) {
            printPaySlipHeader();
            printEmpDetails(emp);
            System.out.println("""
                               No Record Found!
                               (Enter any key to go back)""");
            String choice = scanner.next();
            if (!choice.isEmpty()) {
                break;
            }
            
            

        }
    }
    
    
}
