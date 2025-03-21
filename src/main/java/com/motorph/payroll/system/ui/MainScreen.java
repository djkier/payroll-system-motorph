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
public class MainScreen {
    private Scanner scanner;
    private ArrayList<Employee> employee;
    private AttachAttendance attendanceScreen;
    private SearchEmployee searchEmployee;
    
    public MainScreen(Scanner scanner, ArrayList<Employee> employee) {
        this.scanner = scanner;
        this.employee = employee;
        this.attendanceScreen = new AttachAttendance(scanner);
        this.searchEmployee = new SearchEmployee(scanner, employee);
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

            if(scanner.hasNextInt()){
                int choice = scanner.nextInt();
                
                switch(choice) {
                    case 1:
                        attendanceScreen.display();
                        break;
                        
                    case 2:
                        searchEmployee.display();
                        break;
                        
                    case 3:
                        System.out.println("number three");
                        break;
                        
                    case 4:
                        System.out.println("number one");
                        break;
                        
                    case 5:
                        System.out.println("number two");
                        break;
                        
                    case 6:
                        System.out.println("number three");
                        scanner.close();
                        System.exit(0);
                        break;    
                        
                    default:
                        System.out.println("Invalid");
                }
                
            } else {
                System.out.println("Invalid input. Please enter a number between 1 to 7.");
                scanner.next();
            }
        }
    }
    

}
