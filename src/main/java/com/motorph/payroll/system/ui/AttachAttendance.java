/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.ui;

import com.motorph.payroll.system.services.OpenFile;
import java.util.Scanner;
/**
 *
 * @author djjus
 */
public class AttachAttendance {
    private Scanner scanner;
    private String fileName;
    
    
    public AttachAttendance(Scanner scanner, String fileName) {
        this.scanner = scanner;
        this.fileName = fileName;
    }
    
    
    public void display() {
        
        while (true) {
            System.out.println("""
                               *************************************
                                          Print Payslip
                               *************************************
                               """ +
                               "Current Attendance file: " + fileName + "\n" +
                               """
                               [1]Enter file name
                               [2]Go back""");
            
            int option = scanner.nextInt();
            if (option == 2) {
                break;
            }

            if (option == 1){
                enterNewFile();
            }
            
        }
    }
    
    public void enterNewFile(){
        System.out.println("""
                           *************************************
                                      Print Payslip
                           *************************************
                           Enter file name:""");

        String choose = scanner.next();
        readFile(choose);
    }
    
    public void setFileName(String name){
        this.fileName = name;
    }
    
    public void readFile(String name){
        OpenFile open = new OpenFile();
        open.openAttendance(name);
        if(open.getIfFileChanged()){
            setFileName(name);
        };
    }
}
