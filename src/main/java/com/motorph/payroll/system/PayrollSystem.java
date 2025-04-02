/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.motorph.payroll.system;
import com.motorph.payroll.system.ui.*;
import com.motorph.payroll.system.models.*;
import com.motorph.payroll.system.services.*;
import java.io.*;
import java.util.*;


/**
 *
 * @author djjus
 */

public class PayrollSystem {
    public static Map<Integer, Employee> employeeDetails = new HashMap<>();
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OpenFile openFile = new OpenFile();
        
        
        String details = "employee-details.csv";
        String attendance = "employee-attendance.csv";
        
        employeeDetails = openFile.openDetails(details);
        openFile.openAttendance(attendance);
        
        int count = 0;
        for (Employee emp : employeeDetails.values()){
            count++;
        }
        System.out.println("Total Employee: " + count);
        
        double salary = 35000;
        
        Deductions de = new Deductions(salary);
        System.out.println("Gross Salary:\t" + salary);
        System.out.println("SSS:\t\t" + de.sss());
        System.out.println("Philhealth:\t" + de.philhealth());
        System.out.println("PAGIBIG:\t" + de.pagIbig());
        System.out.println("Deductions:\t" + de.totalDeduction());
        System.out.println("Net Salary:\t" + (salary - de.totalDeduction()));
        System.out.println("--------------------------------------------");
        System.out.println("Withholding Tax\t" + de.withholdingTax());
        System.out.println("Net Salary:\t" + (salary - de.totalDeduction() - de.withholdingTax()));

//        MainScreen mainScreen = new MainScreen(scanner, employeeDetails);
//        mainScreen.display();

    }
    

}
