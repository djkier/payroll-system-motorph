/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.models;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author djjus
 */
public class Employee {
    private String id;
    private String lastName;
    private String firstName;
    private String birthDate;
    private String address;
    private String phone;
    private String sss;
    private String philhealth;
    private String tin;
    private String pagibig;
    private String status;
    private String position;
    private String immSup;
    private Double basicSalary;
    private Double riceSubs;
    private Double phoneAll;
    private Double clothingAll;
    private Double semiMonthlySal;
    private Double hourlyRate;
    private TreeMap<LocalDate, Attendance> attendanceRecords;
    
    public Employee (String id, String lastName, String firstName, String birthDate, String address, String phone, String sss, 
            String philhealth, String tin, String pagibig, String status, String position, String immSup, String basicSalary, 
            String riceSubs, String phoneAll, String clothingAll, String semiMonthlySal, String hourlyRate) {
        
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.sss = sss;
        this.philhealth = philhealth;
        this.tin = tin;
        this.pagibig = pagibig;
        this.status = status;
        this.position = position;
        this.immSup = immSup;
        this.basicSalary = numberParser(basicSalary);
        this.riceSubs = numberParser(riceSubs);
        this.phoneAll = numberParser(phoneAll);
        this.clothingAll = numberParser(clothingAll);
        this.semiMonthlySal = numberParser(semiMonthlySal);
        this.hourlyRate = numberParser(hourlyRate);
        this.attendanceRecords = new TreeMap<>();
    }
    
    private Double numberParser(String money) {
        String noComma = money.replace(",", "");
        String noQuotations = noComma.replace("\"", "");
        return Double.valueOf(noQuotations);
        
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void addAttendance(String date, Attendance record){
        String[] sliceDate = date.split("/");

        attendanceRecords.put(LocalDate.of(
                Integer.valueOf(sliceDate[2]),
                Integer.valueOf(sliceDate[0]),
                Integer.valueOf(sliceDate[1])), record);
        

    }
    
    public Map<LocalDate, Attendance> getAttendanceDec(){
        return this.attendanceRecords.subMap(LocalDate.of(2024, 1, 2), LocalDate.of(2024, 6, 1));
    }
    
    @Override
    public String toString(){
//        return "Employee no.:\t" + this.id +
//                "\nName:\t\t" + this.lastName + ", " + this.firstName + 
//                "\nBirthday:\t" + this.birthDate +
//                "\nTest:\t\t" + this.hourlyRate;
        Map<LocalDate, Attendance> decRecords = getAttendanceDec();
        String records = "";
        for (Map.Entry<LocalDate, Attendance> entry : decRecords.entrySet()) {
            records = records + entry.getValue() + "\n";
        }
        
        if (records.equals("")) {
            records = "No Record Found!";
        }
        
        String template = 
                "Employee No.: " + this.id + "\tLast Name: " + this.lastName +
               "\nDate\t\tTime In\t\tTime Out\tTotal Hours\n";
                
        
        
        
        return template + records;
    }
}
