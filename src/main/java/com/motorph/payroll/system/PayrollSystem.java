/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.motorph.payroll.system;
import com.motorph.payroll.system.ui.*;
import com.motorph.payroll.system.models.*;
import com.motorph.payroll.system.services.*;
import java.io.*;
import java.util.*;

import java.time.LocalDate;


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

        MainScreen mainScreen = new MainScreen(scanner, employeeDetails);
        mainScreen.display();

    }
    

}
