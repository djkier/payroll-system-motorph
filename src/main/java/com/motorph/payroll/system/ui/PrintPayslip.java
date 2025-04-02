/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.ui;
import com.motorph.payroll.system.models.*;
import com.motorph.payroll.system.services.Payslip;
import com.motorph.payroll.system.services.StringDate;
import java.util.Scanner;
import java.util.Map;
import java.time.YearMonth;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author djjus
 */
public class PrintPayslip {
    private Scanner scanner;
    private Map<Integer, Employee> employeeRecords;
    
    public PrintPayslip(Scanner scanner, Map<Integer, Employee> empRec) {
        this.scanner = scanner;
        this.employeeRecords = empRec;
    }
    
    public void display(){
        
        while (true) {
            printPaySlipHeader();
            System.out.println("Enter Employee Number:(Enter 1 to go back)");
            
            if (scanner.hasNextInt()){
                int choice = scanner.nextInt();
                if (choice == 1) {
                    break;
                }
                resultDisplay(choice);
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }            
            
            
        }
        
    }
    
    public void resultDisplay(int choice){
        if(employeeRecords.containsKey(choice)) {
            chooseType(employeeRecords.get(choice));
        } else {
            System.out.println("Employee do not exist.");
        }
    }
    
    public void printPaySlipHeader(){
        System.out.println("""
                            *************************************
                                         Print Payslip
                            *************************************""");
    }
    
    public void printEmpDetails(Employee emp){
        
        System.out.println("Employee Number: " + emp.getId() +
                            "\nEmployee Name: " + emp.getFullName() +
                            "\nAvailable Record: " + emp.availableRecord());        
    }
    
    public void chooseType(Employee emp) {
        boolean exit = false;
        while(!exit) {
            printPaySlipHeader();
            printEmpDetails(emp);
                    
            System.out.println("""
                               How would you like to view the payslip?
                               [1]Full Month/Bi-Month
                               [2]Custom Range
                               [3]Go Back
                               """);
            
            if (scanner.hasNextInt()){
                int choice = scanner.nextInt();
                
                switch(choice) {
                    case 1:
                        chooseMonth(emp);
                        break;
                        
                    case 2:
                        customRange(emp);
                        break;
                        
                    case 3:
                        exit = true;
                        break;
                    
                    default: 
                        System.out.println("Invalid");
                }
                
            } else {
                System.out.println("Invalid input. Please enter a number between 1 to 3.");
                scanner.next();
            }     
        }
    }
    
    public void chooseMonth(Employee emp){
        boolean exit = false;
        while(!exit) {
            printPaySlipHeader();
            printEmpDetails(emp);
            System.out.println("""
                               Which Month?
                               [1]January           [7]July
                               [2]February          [8]August
                               [3]March             [9]September
                               [4]April             [10]October
                               [5]May               [11]November
                               [6]June              [12]December
                               ----------------------------------
                               Enter [13] to go back:"""); 
            
            if (scanner.hasNextInt()){
                int choice = scanner.nextInt();
                
                if (choice == 13) {
                    exit = true;
                } else if (emp.monthExist(choice)){
                    recordExist(emp, choice);
                } else {
                    noRecord(emp);
                }
                
            } else {
                System.out.println("Invalid input. Please enter a number between 1 to 13.");
                scanner.next();
            }  
        }
    }
    
    public void noRecord(Employee emp){
        while(true) {
            printPaySlipHeader();
            printEmpDetails(emp);
            System.out.println("""
                               No Record Found!
                               (Enter any key to go back)""");
            String choice = scanner.next();
            if (!choice.isEmpty()) {
                break;
            }
        }
    }
    
    public void recordExist(Employee emp, int month) {
        boolean exit = false;
        while(!exit) {
            printPaySlipHeader();
            printEmpDetails(emp);
            System.out.println("""
                               What type?
                               [1]Full Month
                               [2]First Half
                               [3]Second Half
                               [4]Go back
                               """);
            if(scanner.hasNextInt()){
                int choice = scanner.nextInt();
                Payslip payslip = new Payslip(emp,scanner);
                YearMonth ym = YearMonth.of(2024, month);
                int lastDay = ym.lengthOfMonth();
                
                switch(choice) {
                    case 1:
                        
                        payslip.display(2024, month, 1, 2024, month, lastDay);
                        break;
                        
                    case 2:
                        
                        payslip.display(2024, month, 1, 2024, month, 16);
                        break;
                        
                    case 3:
                        
                        payslip.display(2024, month, 16, 2024, month, lastDay);
                        break;
                        
                    case 4:
                        exit = true;
                        break;
                        
                    default: 
                        System.out.println("Invalid input. Please enter a number between 1 to 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 to 4.");
                scanner.next();
            }
        }
    }
    
    public void customRange(Employee emp){
        Payslip payslip = new Payslip(emp,scanner);
        while(true) {
            printPaySlipHeader();
            printEmpDetails(emp);
            System.out.println("Enter starting date(YYYY-MM-DD): (Enter [1] to go back)");
            String date1 = askForValidDate();
            if (date1.equals("1")){
                break;
            }
 
            System.out.println("From " + date1 + " to ?");
            System.out.println("Enter end date(YYYY-MM-DD): (Enter [1] to change starting date)");
            String date2 = askForValidDate();
            if (date2.equals("1")) {
                continue;
            }
            
            if (isValidOrder(date1, date2)){
                System.out.println("From " + date1 + " to " + date2);
                StringDate start = new StringDate(date1);
                StringDate end = new StringDate(date2);
                payslip.display(start.getYear(), start.getMonth(), start.getDay(), end.getYear(), end.getMonth(), end.getDay());
                break;
            }
            
            System.out.println("Starting date should be earlier than end date! ");
        }
    }
    
    public boolean isValidOrder(String date1, String date2) {
        return convertDate(date1).isBefore(convertDate(date2));
    }
    
    public LocalDate convertDate(String date){
        StringDate d = new StringDate(date);
        return LocalDate.of(d.getYear(), d.getMonth(), d.getDay());
    }
    
    
    public String askForValidDate(){
        String output;
        while(true){
            String date = scanner.next();
            if (date.equals("1")){
                output = date;
                break;
            }
            
            if (isValidFormat(date)){
                output = date;
                break;
            }
            
            System.out.println("""
                               Invalid Date!
                               Date format (YYYY-MM-DD)
                               Enter again: (Enter [1] to go back)""");
        }
        
        return output;
    }
    
    public boolean isValidFormat(String date) {
        if (!date.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
            return false;
        }
        
        return isValidDate(date);
    }
    
    public boolean isValidDate(String date) {
        StringDate d = new StringDate(date);
        
        return isValidMonth(d.getMonth()) && isValidDay(d.getYear(), d.getMonth(), d.getDay());
    }
    
    public boolean isValidMonth(int month) {
        return month <= 12;
    }
    
    public boolean isValidDay(int year, int month, int day){
        YearMonth ym = YearMonth.of(year, month);
        
        return day <= ym.lengthOfMonth();
        
    }
}
