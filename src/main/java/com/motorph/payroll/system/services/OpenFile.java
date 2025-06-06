/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.services;
import com.motorph.payroll.system.models.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author djjus
 */
public class OpenFile {
    //Employee No, Record
    private final Map<Integer, Employee> employeeMap;
    private boolean fileChanged;
    
    public OpenFile() {
        this.employeeMap = new HashMap<>();
        this.fileChanged = false;
    }
    
    public ArrayList<String> open(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
    
        if (inputStream == null) {
            System.out.println("File not found!");
            this.fileChanged = false;
            return list;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
                System.out.println("File does not exist!");
                this.fileChanged = false;

        }
        
        return list;
    }
    
    public Map<Integer, Employee> openDetails(String fileName) {
        ArrayList<String> list = open(fileName);
        
        for (int i = 1; i < list.size(); i++) {
            
            String[] emp = cleanSplit(list.get(i));

            Employee employee = new Employee(
                emp[0], emp[1], emp[2], emp[3], emp[4],
                emp[5], emp[6], emp[7], emp[8], emp[9],
                emp[10], emp[11], emp[12], emp[13], emp[14],
                emp[15], emp[16], emp[17], emp[18]                
            );

            employeeMap.put(Integer.valueOf(emp[0]), employee);
        }

        return employeeMap;
    }
    
    public void openAttendance(String fileName) {
        ArrayList<String> list = open(fileName);
        if (list.isEmpty()){
            System.out.println("File does not exist!");
            return;
        }
        clearAttendance();
        for (int i = 1; i < list.size(); i++) {
            
            String[] att = cleanSplit(list.get(i));
            
            Attendance details = new Attendance(
                    //empNo, date, time in, time out
                    att[0], att[3], att[4], att[5]
            );
            employeeMap.get(Integer.valueOf(att[0])).addAttendance(att[3], details);

        }
        this.fileChanged = true;

    }
    
    public void clearAttendance(){
        for (Integer e : employeeMap.keySet()){
            employeeMap.get(e).clearAttendance();
        }
    }
    
    
    public String[] cleanSplit(String line) {
        return line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    }
    
    public boolean getIfFileChanged(){
        return this.fileChanged;
    }
    
}
