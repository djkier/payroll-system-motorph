/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.motorph.payroll.system;
import com.motorph.payroll.system.ui.*;
import com.motorph.payroll.system.models.*;
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
        MainScreen mainScreen = new MainScreen(scanner, employeeDetailsList);
        String sampleEmployee = "10001,Garcia,Manuel III,10/11/1983,\"Valero Carpark Building Valero Street 1227, Makati City\",966-860-270,44-4506057-3,820126853951,442-605-657-000,691295330870,Regular,Chief Executive Officer,N/A,\"90,000\",\"1,500\",\"2,000\",\"1,000\",\"45,000\",535.71";
        String sampleAttendance = "10001,Garcia,Manuel III,06/03/2024,8:59,18:31";

        System.out.println("Hello World!");
        factoryEmployee(sampleEmployee);
//        viewEmployeeDetails();


        mainScreen.display();
    }
    
    public static void factoryEmployee(String line) {
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
