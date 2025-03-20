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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employeeDetailsList = new ArrayList<>();
        
        
        //sample record
        String employee1 = "10001,Garcia,Manuel III,10/11/1983,\"Valero Carpark Building Valero Street 1227, Makati City\",966-860-270,44-4506057-3,820126853951,442-605-657-000,691295330870,Regular,Chief Executive Officer,N/A,\"90,000\",\"1,500\",\"2,000\",\"1,000\",\"45,000\",535.71";
        

        System.out.println("Hello World!");
        System.out.println("Im Here!!");
        System.out.println(employee1);
        
        String[] emp = employee1.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        
        Employee employee = new Employee(
            emp[0], emp[1], emp[2], emp[3], emp[4],
            emp[5], emp[6], emp[7], emp[8], emp[9],
            emp[10], emp[11], emp[12], emp[13], emp[14],
            emp[15], emp[16], emp[17], emp[18]                
        );
        
        System.out.println(employee);
        
        
//        while (true) {
//            System.out.println("Enter a number:");
//            int scan = scanner.nextInt();
//
//            if (scan == 1) {
//                break;
//            }
//            
//            System.out.println("Click 1 to exit");
//        }
//        
//        scanner.close();
    }
}
