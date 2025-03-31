/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.services;


import static com.motorph.payroll.system.PayrollSystem.employeeDetailsList;
import com.motorph.payroll.system.models.Employee;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author djjus
 */
public class OpenFile {
    private final ArrayList<Employee> employeeList;

    
    public OpenFile() {
        this.employeeList = new ArrayList<>();
    }
    
    public ArrayList<String> open(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
    
        if (inputStream == null) {
            System.out.println("File not found!");
            return list;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        }
        
        catch (Exception e) {
                e.printStackTrace();
        }
        
        return list;
    }
    
    public ArrayList<Employee> openDetails(String fileName) {
        ArrayList<String> list = open(fileName);
        
        for (int i = 1; i < list.size(); i++) {
            
            String[] emp = cleanSplit(list.get(i));

            Employee employee = new Employee(
                emp[0], emp[1], emp[2], emp[3], emp[4],
                emp[5], emp[6], emp[7], emp[8], emp[9],
                emp[10], emp[11], emp[12], emp[13], emp[14],
                emp[15], emp[16], emp[17], emp[18]                
            );

            employeeList.add(employee);
        }

        return employeeList;
    }
    
    public String[] cleanSplit(String line) {
        return line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    }
    
}
