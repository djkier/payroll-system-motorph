/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.services;
import com.motorph.payroll.system.models.*;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.time.LocalDate;
import java.time.Month;
import java.text.DecimalFormat;
/**
 *
 * @author djjus
 */
public class Payroll {
    private Scanner scanner;
    private TreeMap<Integer, Employee> empRecords;
    private double totalGross;
    private double totalDeductions;
    private double totalNet;
    
    public Payroll(Scanner scanner, Map<Integer, Employee> empRecords) {
        this.scanner = scanner;
        this.empRecords = new TreeMap<>(empRecords);
        this.totalGross = 0;
        this.totalDeductions = 0;
        this.totalNet = 0;
    }
    
    public void display(int choice){
        LocalDate start = LocalDate.of(2024, choice, 1);
        LocalDate end = start.plusMonths(1);
        Integer firstKey = empRecords.firstKey();
        Employee firstEmp = empRecords.get(firstKey);
        
        if ((start.isBefore(firstEmp.firstEntry()) && end.isBefore(firstEmp.firstEntry())) || 
            ((start.isAfter(firstEmp.lastEntry())) && end.isAfter(firstEmp.lastEntry()))) {
            noRecord(choice);
            return;
        }
        
        while(true){
            header(choice);
            for (Integer id : empRecords.keySet()) {
                System.out.println(empRecordDisplay(empRecords.get(id), choice));
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Total" + "\t\t\t\t\t\t\t\t\t\t" + money(this.totalGross) + "\t" + money(this.totalDeductions) + "\t" + money(this.totalNet));
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\n(Enter any key to print and exit)");
            String exit = scanner.next();
            if (exit.length() > 0) {
                break;
            }
        }
    }
    
    public String empRecordDisplay(Employee emp, int choice) {
        LocalDate end = LocalDate.of(2024, choice, 1).plusMonths(1);

        Map<LocalDate, Attendance> customMonth = emp.getAttendanceCus(2024, choice, 1, end.getYear(), end.getMonthValue(), end.getDayOfMonth());
        double grossSalary = workedHours(customMonth) * emp.getHourlyRate();
        this.totalGross += grossSalary;
        
        Deductions deduction = new Deductions(grossSalary);
        double totalDed = deduction.totalDeduction() + deduction.withholdingTax();
        this.totalDeductions += totalDed;

        double net = grossSalary - totalDed;
        this.totalNet += net;
        
        
        return emp.getId() + "\t\t" + stringFormat(emp.getFullName()) +  stringFormat(emp.getPosition()) + "\t" + money(grossSalary) + "\t" + money(totalDed) + "\t" + money(net);
    }
    
    public double workedHours(Map<LocalDate, Attendance> subMap) {
        double hours = 0;
        
        for(LocalDate date : subMap.keySet()){
            hours += subMap.get(date).getWorkingHours();
        }
        
        
        return hours;
    }
    
    public void noRecord(int choice){
        while(true) {
            header(choice);
            System.out.println("No Record Found!");
            System.out.println("\n(Enter any key to go back.)");
            String exit = scanner.next();
            if (exit.length() > 0) {
                break;
            }
        }
    }
    
    
    public void header(int choice) {
        Month month = Month.of(choice);
        System.out.println("""
            ----------------------------------------------------------------------------------------------------------------------------
            MotorPH
            7 Jupiter Avenue Cor., Bagong Nayon, Quezon City
            Phone: (028) 911-5071 / (028) 911-5072 / (028) 911-5073 
            Email: corporate@motorph.com
            ----------------------------------------------------------------------------------------------------------------------------
            Payroll Summary for the Month of  """ + " " + month + " 2024" + 
            """
            
            ----------------------------------------------------------------------------------------------------------------------------
            Employee No.    Employee Name                 Position                          Gross Salary    Deductions      Net Pay""");
    }
    
    
    public String money(double amount){
        String money = numberFormat(amount);

        return "P" + money;
    }
    
    public String numberFormat(double amount){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String formatted = df.format(amount);
        
//        spacing
        while(formatted.length() < 11){
            formatted = " " + formatted; 
        }
        
        return formatted;
    }
    
    
    public String stringFormat(String str){
        String formatted = str;
        while(formatted.length() < 30) {
            formatted = formatted + " ";
        }
        
        return formatted;
    }
}
