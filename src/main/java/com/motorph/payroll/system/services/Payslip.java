/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.services;
import com.motorph.payroll.system.models.Employee;
import java.util.Scanner;
import java.text.DecimalFormat;


/**
 *
 * @author djjus
 */
public class Payslip {
    private Employee emp;
    private int month;

    private Scanner scanner;
    
    public  Payslip(Employee emp, int month, Scanner scanner) {
        this.emp = emp;
        this.month = month;
        this.scanner = scanner;
    }
    
    public Payslip(Scanner scanner) {
        this.scanner = scanner;
        
    }
    

    public void display(int start, int end){
        while(true) {
            
            double totalBenefits = emp.getRiceSubs() + emp.getPhoneAll()+ emp.getClothingAll();
            
            System.out.println("""
                               ----------------------------------------------------------------------
                               MotorPH
                               7 Jupiter Avenue Cor., Bagong Nayon, Quezon City
                               Phone: (028) 911-5071 / (028) 911-5072 / (028) 911-5073 
                               Email: corporate@motorph.com
                               ----------------------------------------------------------------------""");
            System.out.println("PAYSLIP NO:\t" + "31-2023-12-30" + "\t\t" + "PERIOD START\t" + "12/18/2023" );
            System.out.println("EMPLOYEE ID:\t" + "10001" + "\t\t\t" + "PERIOD END\t" + "12/18/2023" );
            System.out.println("EMPLOYEE NAME:\t" + emp.getFullName());
            System.out.println("POSITION\t" + emp.getPosition());
            System.out.println("----------------------------------------------------------------------");
            System.out.println("EARNINGS");
            System.out.println("Monthly Rate\t\t\t\t\t" + money(emp.getBasicSalary()));
            System.out.println("Hourly Rate\t\t\t\t\t" +  money(emp.getHourlyRate()));
            System.out.println("Hours Worked\t\t\t\t\t " + numberFormat(10.0));
            System.out.println("Overtime\t\t\t\t\t" + money(10000.0));
            System.out.println("Gross Income\t\t\t\t\t" + money(10000.0));
            System.out.println("----------------------------------------------------------------------");
            System.out.println("BENEFITS");
            System.out.println("Rice Subsidy\t\t\t\t\t" + money(emp.getRiceSubs()));
            System.out.println("Phone Allowance\t\t\t\t\t" + money(emp.getPhoneAll()));
            System.out.println("Clothing Allowance\t\t\t\t" + money(emp.getClothingAll()));
            System.out.println("Total\t\t\t\t\t\t" + money(totalBenefits));
            System.out.println("----------------------------------------------------------------------");
            System.out.println("DEDUCTIONS");
            System.out.println("Social Security System\t\t\t\t" + money(10000.0));
            System.out.println("Philhealth\t\t\t\t\t" + money(10000.0));
            System.out.println("PAGIBIG\t\t\t\t\t\t" + money(10000.0));
            System.out.println("Total\t\t\t\t\t\t" + money(10000.0));
            System.out.println("----------------------------------------------------------------------");
            System.out.println("SUMMARY");
            System.out.println("Gross Income\t\t\t\t\t" + money(10000.0));
            System.out.println("Benefits\t\t\t\t\t" + money(totalBenefits));
            System.out.println("Deductions\t\t\t\t\t" + money(10000.0));
            System.out.println("Less Withholding Tax\t\t\t\t" + money(10000.0));
            System.out.println("----------------------------------------------------------------------");
            System.out.println("TAKE HOME PAY\t\t\t\t\t" + money(10000.0));
            
            
            System.out.println("\n(Enter any key to print and go back)");
            String choice = scanner.next();
            if(!choice.isEmpty()){
                break;
            }
            
        }
    }
    public String money(double amount){
        String money = numberFormat(amount);

        return "P" + money;
    }
    
    public String numberFormat(double amount){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String formatted = df.format(amount);
        
        //spacing
        while(formatted.length() < 10){
            formatted = " " + formatted; 
        }
        
        return formatted;
    }
}
