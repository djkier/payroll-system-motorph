/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system;

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
    }
    
    private Double numberParser(String money) {
        String noComma = money.replace(",", "");
        String noQuotations = noComma.replace("\"", "");
        return Double.valueOf(noQuotations);
        
    }
    
    
    
    public String toString(){
        return "*************************************" +
               "\nEmployee no.: " + this.id +
                "\nName: " + this.lastName + ", " + this.firstName + 
                "\nBirthday: " + this.birthDate +
                "\n*************************************"
                ;
    }
}
