/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.services;
import com.motorph.payroll.system.models.Employee;
import java.time.LocalDate;
import java.time.YearMonth;


/**
 *
 * @author djjus
 */
public class Benefits {
    private LocalDate start;
    private LocalDate end;
    private Employee emp;

    
    public Benefits(LocalDate start, LocalDate end, Employee emp) {
        this.start = start;
        this.end = end;
        this.emp = emp;
    }
    
    

    public double daysInAMonth(){
        if (this.start.isBefore(emp.firstEntry())){
            this.start = LocalDate.of(2024,6,1);
        }
        
        if (this.end.isAfter(emp.lastEntry())) {
            this.end = LocalDate.of(2024, 12, 31);
        }
        
        if (sameMonth(this.start, this.end)){
            int diff = this.end.getDayOfMonth() - this.start.getDayOfMonth() + 1;

            return 1.0 * diff/totalDays(this.start);
        }
        

        double startFrac = 1.0 * (totalDays(this.start) - this.start.getDayOfMonth() + 1) / totalDays(this.start);
        double endFrac = 1.0 * this.end.getDayOfMonth() / totalDays(this.end);
        double totalFrac = startFrac + endFrac + monthDiff(this.start, this.end);

        return totalFrac;
    }
    
    
    public boolean sameMonth(LocalDate start, LocalDate end){
        YearMonth ymS = YearMonth.from(start);
        YearMonth ymE = YearMonth.from(end);
        
        return ymS.equals(ymE);
    }
    
    public int totalDays(LocalDate date){
        YearMonth ym = YearMonth.from(date);
        return ym.lengthOfMonth();
    }
    
    public int monthDiff(LocalDate start, LocalDate end){
        YearMonth ymS = YearMonth.from(start);
        YearMonth ymE = YearMonth.from(end);
        
        int yearDiff = ymE.getYear() - ymS.getYear();
        int monDiff = ymE.getMonthValue() - ymS.getMonthValue();
        
        return (yearDiff * 12) + monDiff - 1;
    }
    
    public double riceSubs(){
        return emp.getRiceSubs() * daysInAMonth();

    }
    
    public double phoneAll(){
        return emp.getPhoneAll() * daysInAMonth();

    }
    
    public double clothingAll(){
        return emp.getClothingAll() * daysInAMonth();

    }
}
