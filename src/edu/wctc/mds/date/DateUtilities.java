/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.mds.date;

import java.time.LocalDate;
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

    public final void setFormat(DateTimeFormatter format) throws IllegalArgumentException {
        if(format == null){
            throw new IllegalArgumentException("No or invlaid format provided");
        }
        this.format = format;
    }
    
    public final String toString(LocalDateTime date, DateTimeFormatter format) {
        String stringDate = date.format(format);
        return stringDate;
    }

    public final Date toDate(String stringDate) {
//        Date date;

        return null;
    }

    public final void calculateDateDifferenceInMinutes(LocalDateTime startDateTime, LocalDateTime endDateTime) {

    }

    public final void calculateDateDifferenceInHours(LocalDateTime startDateTime, LocalDateTime endDateTime) {

    }

    public final void calculateDateDifferenceInDays(LocalDate startDate, LocalDate endDate) {

    }

    public final void getDateInFuture(LocalDate currentDate, int numberOfDays) {

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
