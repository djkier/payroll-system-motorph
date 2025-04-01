/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.services;
import com.motorph.payroll.system.models.Employee;
import java.util.Scanner;

/**
 *
 * @author djjus
 */
public class Payslip {
    private Employee emp;
    private int month;
    private int start;
    private int end;
    private Scanner scanner;
    
    public  Payslip(Employee emp, int month, int start, int end, Scanner scanner) {
        this.emp = emp;
        this.month = month;
        this.start = start;
        this.end = end;
        this.scanner = scanner;
    }
    
    public Payslip(Scanner scanner) {
        this.scanner = scanner;
        
    }
    

    public void display(){
        while(true) {
            System.out.println("""
                               ----------------------------------------------------------------------
                               MotorPH
                               7 Jupiter Avenue Cor., Bagong Nayon, Quezon City
                               Phone: (028) 911-5071 / (028) 911-5072 / (028) 911-5073 
                               Email: corporate@motorph.com
                               ----------------------------------------------------------------------""");
            System.out.println("PAYSLIP NO:\t" + "31-2023-12-30" + "\t\t" + "PERIOD START\t" + "12/18/2023" );
            System.out.println("EMPLOYEE ID:\t" + "10001" + "\t\t\t" + "PERIOD END\t" + "12/18/2023" );
            System.out.println("EMPLOYEE NAME:\t" + "name name name" + "\t\t" + "POSITION\t" + "Accounting" );
            System.out.println("----------------------------------------------------------------------");
            System.out.println("EARNINGS");
            System.out.println("Monthly Rate\t\t\t\t\t" + "P" + "10,000.00");
            System.out.println("Daily Rate\t\t\t\t\t" + "P" + "10,000.00");
            System.out.println("Days Worked\t\t\t\t\t" + "\t" + "10");
            System.out.println("Overtime\t\t\t\t\t" + "P" + "10,000.00");
            System.out.println("Gross Income\t\t\t\t\t" + "P" + "10,000.00");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("BENEFITS");
            System.out.println("Rice Subsidy\t\t\t\t\t" + "P" + "10,000.00");
            System.out.println("Phone Allowance\t\t\t\t\t" + "P" + "10,000.00");
            System.out.println("Clothing Allowance\t\t\t\t" + "P" + "10");
            System.out.println("Total\t\t\t\t\t\t" + "P" + "10,000.00");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("DEDUCTIONS");
            System.out.println("Social Security System\t\t\t\t" + "P" + "10,000.00");
            System.out.println("Philhealth\t\t\t\t\t" + "P" + "10,000.00");
            System.out.println("PAGIBIG\t\t\t\t\t\t" + "P" + "10");
            System.out.println("Total\t\t\t\t\t\t" + "P" + "10,000.00");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("SUMMARY");
            System.out.println("Gross Income\t\t\t\t\t" + "P" + "10,000.00");
            System.out.println("Benefits\t\t\t\t\t" + "P" + "10,000.00");
            System.out.println("Deductions\t\t\t\t\t" + "P" + "10,000.00");
            System.out.println("Less Withholding Tax\t\t\t\t" + "P" + "10");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("TAKE HOME PAY\t\t\t\t\t" + "P" + "10,000.00");
            
            
            System.out.println("\n(Enter any key to print and go back)");
            String choice = scanner.next();
            if(!choice.isEmpty()){
                break;
            }
            
        }
    }
}
