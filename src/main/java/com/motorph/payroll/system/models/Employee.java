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
import java.time.Month;
import java.time.YearMonth;

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
    
    public Employee() {
        this.id = "No Record";
        this.lastName = "Unknown";
        this.firstName = "Unknown";
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
    
    public String getFullName() {
        return this.lastName + ", " + this.firstName;
    }
    
    public String getPosition() {
        return this.position;
    }
    
    public Double getBasicSalary() {
        return this.basicSalary;
    }
    
    public Double getHourlyRate() {
        return this.hourlyRate;
    }
    
    public Double getRiceSubs(){
        return this.riceSubs;
    }
    
    public Double getPhoneAll() {
        return this.phoneAll;
    }
    
    public Double getClothingAll() {
        return this.clothingAll;
    }
    
    public void addAttendance(String date, Attendance record){
        String[] sliceDate = date.split("/");

        //need to check if the date exist
        
        attendanceRecords.put(LocalDate.of(
                Integer.valueOf(sliceDate[2]),
                Integer.valueOf(sliceDate[0]),
                Integer.valueOf(sliceDate[1])), record);
    }
    
    public void clearAttendance() {
        attendanceRecords.clear();
    }
    
    public String availableRecord(){
        return this.attendanceRecords.firstKey() + " to " + this.attendanceRecords.lastKey();
    }
    
    public Boolean monthExist(int month){
        for(LocalDate date : attendanceRecords.keySet()){
            if (date.getMonthValue() == month){
                return true;
            }
        }
        
        return false;
    }
    
    
    //customizable attendance recovery, return is a sub Map
    public Map<LocalDate, Attendance> getAttendanceCus(int startYear, int startMonth, int startDate, int endYear, int endMonth, int endDate){
        return this.attendanceRecords.subMap(LocalDate.of(startYear, startMonth, startDate), LocalDate.of(endYear, endMonth, endDate));
    }
    
    public LocalDate firstEntry(){
        return this.attendanceRecords.firstKey();
    }
    
    public LocalDate lastEntry(){
        return this.attendanceRecords.lastKey();
    }
    
    public void totalAttendance(){
        double totalHours = 0;
        for (Attendance att : attendanceRecords.values()) {
            totalHours += att.getWorkingHours();
        }
        
        //clean totalHours
        double result = Math.round(totalHours * 100.0 ) / 100.0;
        
        System.out.println("Total Record: " + attendanceRecords.size() + "\tTotal Hours: " + result);
    }
    
    @Override
    public String toString(){
        return "Employee no.:\t" + this.id +
                "\nName:\t\t" + this.lastName + ", " + this.firstName + 
                "\nBirthday:\t" + this.birthDate;
        
//        for attendance test
//        Map<LocalDate, Attendance> decRecords = getAttendanceCus();
//        String records = "";
//        for (Map.Entry<LocalDate, Attendance> entry : decRecords.entrySet()) {
//            records = records + entry.getValue() + "\n";
//        }
//        
//        if (records.equals("")) {
//            records = "No Record Found!";
//        }
//        
//        String template = 
//                "Employee No.: " + this.id + "\tLast Name: " + this.lastName +
//               "\nDate\t\tTime In\t\tTime Out\tTotal Hours\n";
//                
//        
//        
//        
//        return template + records;
    }
}
