/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.ui;
import com.motorph.payroll.system.models.Employee;

import java.util.Scanner;
import java.util.Map;

/**
 *
 * @author djjus
 */
public class PayrollReport {
    private Scanner scanner;
    private Map<Integer, Employee> empRecords;
    
    
    public PayrollReport(Scanner scanner, Map<Integer, Employee> empRecords) {
        this.scanner = scanner;
        this.empRecords = empRecords;
        
    }
    
    public void display(){
        System.out.println("Payroll Report");
    }
    
}
