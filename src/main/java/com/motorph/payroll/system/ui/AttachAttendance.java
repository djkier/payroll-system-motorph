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
public class AttachAttendance {
    private Scanner scanner;
    
    
    public AttachAttendance(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void display() {
        
        while (true) {
            System.out.println("""
                               *************************************
                                          Print Payslip
                               *************************************
                               Work in Progress!
                               [1]Go back""");
            
            int option = scanner.nextInt();
            if (option == 1) {
                break;
            }
        }
        
        
        
    }
}
