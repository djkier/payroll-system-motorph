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
        
        
        //placeholder list change it to Map<Integer, Employee>

        
        MainScreen mainScreen = new MainScreen(scanner, employeeDetails);
        mainScreen.display();
//        String sampleEmployee = "10001,Garcia,Manuel III,10/11/1983,\"Valero Carpark Building Valero Street 1227, Makati City\",966-860-270,44-4506057-3,820126853951,442-605-657-000,691295330870,Regular,Chief Executive Officer,N/A,\"90,000\",\"1,500\",\"2,000\",\"1,000\",\"45,000\",535.71";
//        String sampleAttendance = "10001,Garcia,Manuel III,06/03/2024,8:59,18:31";
//        
//        
    }
    

}
