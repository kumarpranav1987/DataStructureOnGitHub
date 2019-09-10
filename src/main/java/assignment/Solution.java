package assignment;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Solution {
 static long feePerDays;
 static long feePerMonth;
 static long feePerYears;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
   try {
            readDate();             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
 
 }
    public static void readDate() throws Exception{
       
        
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d M yyyy");
        final Scanner scanner = new Scanner(System.in);      
        final String firstInput = scanner.nextLine();       
        final String secondInput = scanner.nextLine();
        scanner.close();
        final LocalDate firstDate = LocalDate.parse(firstInput, formatter);
        final LocalDate secondDate = LocalDate.parse(secondInput, formatter);
        //final long days = Math.abs(ChronoUnit.DAYS.between(firstDate, secondDate));
        //final long months = Math.abs(ChronoUnit.MONTHS.between(firstDate, secondDate));
        //final long years = Math.abs(ChronoUnit.YEARS.between(firstDate, secondDate));  
   
        final long days = (ChronoUnit.DAYS.between( secondDate,firstDate));
        final long months = (ChronoUnit.MONTHS.between(secondDate,firstDate));
        final long years = (ChronoUnit.YEARS.between(secondDate,firstDate));
        calcalateBookDate(days, months, years);       
        
 
    }
    public static void calcalateBookDate(long days, long months, long years) {
        
        if (days == 0) {
            System.out.println(days);
        }
        if(days >= 1 && days <= 31) {
            feePerDays = days * 15;
            setDateDays(feePerDays);
        }
        if (months != 0 && months <= 12) {
            
            feePerMonth = months * 500;
            setDateMonth( feePerMonth);        
           
        }
        
        if (years != 0 && years <= 3000) {
            feePerYears = years * 1000;
            setDateYear(feePerYears);
        }
    }
    
public static void setDateDays(long feePerDays){
        
        long totalDayfee = feePerDays;
         System.out.println(totalDayfee);
    }


    public static void setDateMonth(long feePerMonth){
        
        long totalMonthFee = feePerMonth;
         System.out.println(totalMonthFee);
    }
    
    
    public static void setDateYear(long feePerYears){
        
        long totlaYearFee = feePerYears;
         System.out.println(totlaYearFee);
    }
}

