/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.services;

/**
 *
 * @author djjus
 */
public class Deductions {
    private double gross;
    
    public Deductions(double gross){
        this.gross = gross;
    }
    
    public double sss(){
        if (this.gross <= 0) {
            return 0;
        }
        
        if (this.gross <= 3250) {
            return 135.0;
        }
        double base = (this.gross - 3250) / 500;
        double contribution = Math.floor(base + 1) * 22.50 + 135;
        
        return precision(contribution/3);
    }
    
    public double philhealth(){
        if (this.gross <= 0) {
            return 0;
        }
        
        if (this.gross <= 10000) {
            return 150;
        }
            
        if (this.gross >= 60000) {
            return 900;
        }
        
        return precision(this.gross * 0.03 / 2);
    }
    
    public double pagIbig(){
        if (this.gross < 1000) {
            return 0;
        }
        
        double contribution;
        
        if (this.gross <= 1500) {
            contribution = this.gross * 0.01;
        } else {
            contribution = this.gross * 0.02;
        }
        
        if (contribution >= 100) {
            contribution = 100;
        }
        
        return precision(contribution);
    }
    
    public double withholdingTax(){
        double net = this.gross - totalDeduction();
        double tax;
        if (net <= 20832) {
            tax = 0;
        } else if ( net < 33333) {
            tax = (net - 20833) * 0.2;
        } else if (net < 66667) {
            tax = 2500 + (net - 33333) * 0.25;
        } else if (net < 166667) {
            tax = 10833 + (net - 66667) * 0.3;
        } else if (net < 666667) {
            tax = 40833 + (net - 166667) * 0.32;
        } else {
            tax = 200833.33 + (net - 666667) * 0.35;
        }
        
        return precision(tax);
        
    }
    
    
    public double totalDeduction(){
        return this.sss() + this.philhealth() + this.pagIbig();
    }
    
    public double precision(double num){
        return Math.round(num * 100.0) / 100.0;
    }
}
