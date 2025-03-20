/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.motorph.payroll.system;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author djjus
 */


public class PayrollSystem {
    public static ArrayList<Employee> employeeDetailsList = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String employee1 = "10001,Garcia,Manuel III,10/11/1983,\"Valero Carpark Building Valero Street 1227, Makati City\",966-860-270,44-4506057-3,820126853951,442-605-657-000,691295330870,Regular,Chief Executive Officer,N/A,\"90,000\",\"1,500\",\"2,000\",\"1,000\",\"45,000\",535.71";


        System.out.println("Hello World!");
        viewInformation(employee1);

        while (true) {
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
                               Enter the number you want to perform:
                               """);
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            if (choice == 6) {
                break;
            }
            
            if (choice == 2) {
                viewEmployeeDetails();
            }
            
            System.out.println("Enter another number!");
        }
        
    }
    
    public static void viewInformation(String line) {
        String[] emp = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        
        Employee employee = new Employee(
            emp[0], emp[1], emp[2], emp[3], emp[4],
            emp[5], emp[6], emp[7], emp[8], emp[9],
            emp[10], emp[11], emp[12], emp[13], emp[14],
            emp[15], emp[16], emp[17], emp[18]                
        );
        
        employeeDetailsList.add(employee);
    }
    
    public static void viewEmployeeDetails() {
        for (Employee emp : employeeDetailsList) {
            System.out.println(emp);
        }
    }
}
