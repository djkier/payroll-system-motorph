/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.ui;
import java.util.Scanner;
/**
 *
 * @author djjus
 */
public class MainScreen {
    private Scanner scanner;
    
    public MainScreen(Scanner scanner) {
        this.scanner = scanner;
    }
    
    
    public void display() {
        while(true) {
            System.out.println("""
                                   *************************************
                                        MotorPH Payroll Main Screen
                                   *************************************
                                   [1] Attach Attendance
                                   [2] View Employee Details
                                   [3] View Attendance
                                   [4] View Gross Salary
                                   [5] View Payslip
                                   [6] Exit
                                   -------------------------------------
                                   Enter the number you want to perform:""");
            int choice = scanner.nextInt();
            System.out.println(choice);
        }
        
    }
}
