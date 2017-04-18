/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.mds.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Mike
 */
public class DateUtilities {

//    LocalDateTime currentDate = LocalDateTime.now().withMonth(12).withDayOfMonth(26);
    private DateTimeFormatter format;

    public final DateTimeFormatter getFormat() {
        return format;
    }

    public final void setFormat(DateTimeFormatter format) {
        this.format = format;
    }
    
    public final String toString(LocalDateTime date) {
        String stringDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        return stringDate;
    }

    public final Date toDate(String stringDate) {

        return null;
    }

    public final void calculateDateDifferenceInMinutes() {

    }

    public final void calculateDateDifferenceInHours() {

    }

    public final void calculateDateDifferenceInDays() {

    }

    public final void getDateInFuture() {

    }
    
    

//    public static void main(String[] args) {
//       
//        DateUtilities du = new DateUtilities();
//            LocalDateTime currentDate = LocalDateTime.now().withMonth(12).withDayOfMonth(26);
//    
//        
//        System.out.println(du.toString(currentDate));
//    }
}
