/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.ui;
import com.motorph.payroll.system.models.Employee;
import com.motorph.payroll.system.services.Payroll;

import java.util.Scanner;
import java.util.Map;

/**
 *
 * @author djjus
 */
public class PayrollReport {
    private Scanner scanner;
    private Map<Integer, Employee> empRecords;
    
    
    public PayrollReport(Scanner scanner, Map<Integer, Employee> empRecords) {
        this.scanner = scanner;
        this.empRecords = empRecords;
        
    }
    
    public void display(){
        while(true) {
            header();
            Payroll payroll = new Payroll(scanner, empRecords);
            System.out.println("Available Record: " + empRecords.get(10001).availableRecord());
            System.out.println("""
                               Make a report for the month of:
                                [1]January           [7]July
                                [2]February          [8]August
                                [3]March             [9]September
                                [4]April             [10]October
                                [5]May               [11]November
                                [6]June              [12]December
                               -----------------------------------
                               Enter [13] to go back:""");
            
            if(scanner.hasNextInt()){
                int choice = scanner.nextInt();
                if (choice == 13) {
                    break;
                }
                
                if (choice >= 1 && choice <= 12) {
                    payroll.display(choice);
                } else {
                    System.out.println("Please enter a number between 1 to 13.");
                }
                
            } else {
                System.out.println("Invalid input. Please enter a number between 1 to 13.");
                scanner.next();
            }
            
            
            
        }
    }
    
    public void header(){
        System.out.println("""
                           *************************************
                                       Payroll Report
                           *************************************""");
    }
    
}
