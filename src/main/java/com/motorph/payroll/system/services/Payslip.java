/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.services;
import com.motorph.payroll.system.models.*;
import java.util.Scanner;
import java.util.Map;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;



/**
 *
 * @author djjus
 */
public class Payslip {
    private Employee emp;

    private Scanner scanner;
    
    public  Payslip(Employee emp, Scanner scanner) {
        this.emp = emp;
        this.scanner = scanner;
    }
    
    public Payslip(Scanner scanner) {
        this.scanner = scanner;
        
    }
    

    public void display(int startYear, int startMonth, int startDate, int endYear, int endMonth, int endDate){
        while(true) {

            if (isLastDay(endYear, endMonth, endDate)) {
                endDate = 1;
                endMonth ++;
                if (endMonth == 13) {
                    endMonth = 1;
                    endYear++;
                }
                
            }
            
            Map<LocalDate, Attendance> customMonth = emp.getAttendanceCus(startYear, startMonth, startDate, endYear, endMonth, endDate);
            
            double totalBenefits = emp.getRiceSubs() + emp.getPhoneAll()+ emp.getClothingAll();
            double grossIncome = emp.getHourlyRate() * totalHoursWorked(customMonth);
            
            Deductions deduction = new Deductions(grossIncome);
            
            System.out.println("""
                               ----------------------------------------------------------------------
                               MotorPH
                               7 Jupiter Avenue Cor., Bagong Nayon, Quezon City
                               Phone: (028) 911-5071 / (028) 911-5072 / (028) 911-5073 
                               Email: corporate@motorph.com
                               ----------------------------------------------------------------------""");
            System.out.println("PAYSLIP NO:\t" + paySlipNumber(emp.getId(), endYear, endMonth, endDate) + "\t\t" + "PERIOD START\t" + LocalDate.of(startYear, startMonth, startDate) );
            System.out.println("EMPLOYEE ID:\t" + emp.getId() + "\t\t\t" + "PERIOD END\t" + LocalDate.of(endYear, endMonth, endDate) );
            System.out.println("EMPLOYEE NAME:\t" + emp.getFullName());
            System.out.println("POSITION\t" + emp.getPosition());
            System.out.println("----------------------------------------------------------------------");
            System.out.println("EARNINGS");
            System.out.println("Monthly Rate\t\t\t\t\t" + money(emp.getBasicSalary()));
            System.out.println("Hourly Rate\t\t\t\t\t" +  money(emp.getHourlyRate()));
            System.out.println("Hours Worked\t\t\t\t\t " + numberFormat(totalHoursWorked(customMonth)));
            System.out.println("Gross Income\t\t\t\t\t" + money(grossIncome));
            System.out.println("----------------------------------------------------------------------");
            System.out.println("BENEFITS");
            System.out.println("Rice Subsidy\t\t\t\t\t" + money(emp.getRiceSubs()));
            System.out.println("Phone Allowance\t\t\t\t\t" + money(emp.getPhoneAll()));
            System.out.println("Clothing Allowance\t\t\t\t" + money(emp.getClothingAll()));
            System.out.println("Total\t\t\t\t\t\t" + money(totalBenefits));
            System.out.println("----------------------------------------------------------------------");
            System.out.println("DEDUCTIONS");
            System.out.println("Social Security System\t\t\t\t" + money(deduction.sss()));
            System.out.println("Philhealth\t\t\t\t\t" + money(deduction.philhealth()));
            System.out.println("PAGIBIG\t\t\t\t\t\t" + money(deduction.pagIbig()));
            System.out.println("Withholding Tax\t\t\t\t" + money(10000.0));
            System.out.println("Total\t\t\t\t\t\t" + money(deduction.totalDeduction()));
            System.out.println("----------------------------------------------------------------------");
            System.out.println("SUMMARY");
            System.out.println("Gross Income\t\t\t\t\t" + money(grossIncome));
            System.out.println("Benefits\t\t\t\t\t" + money(totalBenefits));
            System.out.println("Deductions\t\t\t\t\t" + money(deduction.totalDeduction()));
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
    
    public Boolean isLastDay(int year, int month, int date){
        LocalDate lastDate = LocalDate.of(year, month, date);
        YearMonth ym = YearMonth.from(lastDate);
        
        
        return date == ym.lengthOfMonth();
    }
    
    public String paySlipNumber(String id, int year, int month, int date){
        String lastThree = id.substring(id.length() - 3);
        return lastThree + "-" + LocalDate.of(year, month, date);
    }
    
    public double totalHoursWorked(Map<LocalDate, Attendance> subMap) {
        double totalHours = 0;
        for (Attendance att : subMap.values()){
            totalHours += att.getWorkingHours();
        }
        
        
        return totalHours;
    }
}
