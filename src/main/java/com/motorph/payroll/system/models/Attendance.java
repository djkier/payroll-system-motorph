/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.models;

/**
 *
 * @author djjus
 */
public final class Attendance {
    private String empNo;
    private String date;
    private String timeIn;
    private String timeOut;
    private double workingHours;
    
    public Attendance(String empNo, String date, String timeIn, String timeOut) {
        this.empNo = empNo;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.workingHours = computeWorkingHours(timeOut, timeIn);
    }
    
    public double computeWorkingHours(String timeOut, String timeIn){
        double result = (convertToHours(timeOut) - convertToHours(timeIn)) / 100.0;
        return Math.round(result * 100.0) / 100.0;
    }
    
    public int convertToHours(String time) {
        String[] timeHrMin = time.split(":");
        int hour = Integer.valueOf(timeHrMin[0]) * 60;
        int min = Integer.valueOf(timeHrMin[1]);
        int total = hour + min;
        
        int hoursInEight = 8 * 60;
        int beforeGrace = hoursInEight + 10;
        
        if (total <= beforeGrace) {
            return hoursInEight;
        }
        
        return total;
    }
    
    public String getTimeIn(){
        return this.timeIn;
    }
    
    public String getTimeOut(){
        return this.timeOut;
    }
    
    public Double getWorkingHours(){
        return this.workingHours;
    }
    
    @Override
    public String toString(){
        return 
//                "Employee No.: " + this.empNo +
//               "\nDate\t\tTime In\t\tTime Out\tTotal Hours\n" +
               this.date + "\t" + this.timeIn + "\t\t" + this.timeOut + "\t\t" + this.workingHours; 
    }
}
