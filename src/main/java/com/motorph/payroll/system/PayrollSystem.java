/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.motorph.payroll.system;
import java.util.Scanner;

/**
 *
 * @author djjus
 */
public class PayrollSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Hello World!");
        System.out.println("Im Here!!");
        
        
        while (true) {
            System.out.println("Enter a number:");
            int scan = scanner.nextInt();

            if (scan == 1) {
                break;
            }
            
            System.out.println("Click 1 to exit");
        }
        
        scanner.close();
    }
}
