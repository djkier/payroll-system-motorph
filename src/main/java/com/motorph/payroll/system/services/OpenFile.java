/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.system.services;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author djjus
 */
public class OpenFile {
    private ArrayList<String> list;
    
    public OpenFile() {
        this.list = new ArrayList<>();
    }
    
    public ArrayList<String> open(String filePath) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
    
        if (inputStream == null) {
            System.out.println("File not found!");
            return null;
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
    
}
