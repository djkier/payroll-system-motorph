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
public class MainScreen {
    private Scanner scanner;
    private Map<Integer, Employee> employee;
    private AttachAttendance attendanceScreen;
    private SearchEmployee searchEmployee;
    private PrintPayslip printPayslip;
    private PayrollReport payrollReport;
    
    
    public MainScreen(Scanner scanner, Map<Integer, Employee> employeeRecords) {
        this.scanner = scanner;
        this.employee = employeeRecords;
        this.attendanceScreen = new AttachAttendance(scanner);
        this.searchEmployee = new SearchEmployee(scanner, employeeRecords);
        this.printPayslip = new PrintPayslip(scanner, employeeRecords);
        this.payrollReport = new PayrollReport(scanner, employeeRecords);
    }
    
    
    public void display() {
        while(true) {
            System.out.println("""
                                   *************************************
                                        MotorPH Payroll Main Screen
                                   *************************************
                                   [1] Attach Attendance
                                   [2] View Employee Details
                                   [3] Print Payslip
                                   [4] Payroll Report
                                   [5] Exit
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
                        printPayslip.display();
                        break;
                        
                    case 4:
                        payrollReport.display();
                        break;
                       
                    case 5:
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
