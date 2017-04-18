/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.mds.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Utility class to assist in using and handling date and times using the new
 * Java API (JDK 8). DateTimeFormatter property added so that user can change
 * format structure of the toString and toDate methods.
 * 
 * @author Mike Sanders, msanders11@my.wctc.edu
 * @version 1.00
 * 
 */
public class DateUtilities {
    
    //DateTimeFormatter property for user to adjsut format structure
    private DateTimeFormatter dateTimeFormat;
    
    /**
     * Method get the current format set to the DateTimeFormatter property
     * 
     * @return the current dateTimeFormat structure when called
     */
    public final DateTimeFormatter getDateTimeFormat() {
        return dateTimeFormat;
    }
    
    /**
     * Method sets the format of the DateTimeFormatter property when called and 
     * provided and valid dateTimeFormat.
     * @param dateTimeFormat
     * @throws IllegalArgumentException - if format is null
     */
    public final void setDateTimeFormat(DateTimeFormatter dateTimeFormat) throws IllegalArgumentException {
        if (dateTimeFormat == null) {
            throw new IllegalArgumentException("No or invlaid format provided");
        }
        this.dateTimeFormat = dateTimeFormat;
    }

    /**
     * Parse the LocalDateTime object to a String and formats the string based upon 
     * the format provided.
     * @param date a LocalDateTime object
     * @param format a DateTimeFormatter object
     * @return LocalDateTime formatted as a string according to the pattern from
     * the DateTimeFormatter
     * @throws IllegalArgumentException - if date or format is null
     */
    public final String toString(LocalDateTime date, DateTimeFormatter format) throws IllegalArgumentException {
        if(date == null){
            throw new IllegalArgumentException("No date provided");
        }
        setDateTimeFormat(format);
        String stringDate = date.format(format);
        return stringDate;
    }

    /**
     * Converts a string date to a Local Date Time, formatted according to the
     * DateTimeFormatter
     * @param stringDate a string date value
     * @param format a DateTimeFormatter object
     * @return the string parsed as a LocalDateTime object
     * @throws IllegalArgumentException - if the string date is null or length
     * is less than 0 or if the format is null
     */
    public final LocalDateTime toLocalDateTime(String stringDate, DateTimeFormatter format) throws IllegalArgumentException {
        if(stringDate == null || stringDate.length() == 0){
            throw new IllegalArgumentException("Please provide a date");
        }
        setDateTimeFormat(format);
        LocalDateTime dateTime = LocalDateTime.parse(stringDate, dateTimeFormat);
        return dateTime;
    }

    /**
     * 
     * @param startDateTime
     * @param endDateTime
     * @return
     * @throws IllegalArgumentException 
     */
    public final long calculateDateDifferenceInMinutes(LocalDateTime startDateTime, LocalDateTime endDateTime) throws IllegalArgumentException {
        if (startDateTime == null) {
            throw new IllegalArgumentException("No start date provided");
        }
        if (endDateTime == null) {
            throw new IllegalArgumentException("No end date provided");
        }
        Duration differenceInMinutes = Duration.between(startDateTime, endDateTime);
        return differenceInMinutes.toMinutes();
    }

    /**
     * 
     * @param startDateTime
     * @param endDateTime
     * @return
     * @throws IllegalArgumentException 
     */
    public final long calculateDateDifferenceInHours(LocalDateTime startDateTime, LocalDateTime endDateTime) throws IllegalArgumentException {
        if (startDateTime == null) {
            throw new IllegalArgumentException("No start date provided");
        }
        if (endDateTime == null) {
            throw new IllegalArgumentException("No end date provided");
        }
        Duration diff = Duration.between(startDateTime, endDateTime);
        return diff.toHours();
    }

    /**
     * 
     * @param startDateTime
     * @param endDateTime
     * @return
     * @throws IllegalArgumentException 
     */
    public final long calculateDateDifferenceInDays(LocalDateTime startDateTime, LocalDateTime endDateTime) throws IllegalArgumentException {
        if (startDateTime == null) {
            throw new IllegalArgumentException("No start date provided");
        }
        if (endDateTime == null) {
            throw new IllegalArgumentException("No end date provided");
        }
        Duration differenceInDays = Duration.between(startDateTime, endDateTime);
        return differenceInDays.toDays();
    }

    /**
     * 
     * @param date
     * @param numberOfDays
     * @return
     * @throws IllegalArgumentException 
     */
    public final LocalDate getDateInFuture(LocalDate date, int numberOfDays) throws IllegalArgumentException {
        LocalDate currentDate = LocalDate.now();
        if (date == null || date.isBefore(currentDate)) {
            throw new IllegalArgumentException("Invalid date provided");
        }
        if (numberOfDays <= 0) {
            throw new IllegalArgumentException("Number of days must be greater than 0");
        }
        return date.plusDays(numberOfDays);
    }

    /**
     * 
     * @param date
     * @param numberOfDays
     * @return 
     */
    public final LocalDate getPastDate(LocalDate date, int numberOfDays) {
        LocalDate currentDate = LocalDate.now();
        if (date == null || date.isAfter(currentDate)) {
            throw new IllegalArgumentException("Invalid date provided");
        }
        if (numberOfDays <= 0) {
            throw new IllegalArgumentException("Number of days must be greater than 0");
        }
        return date.minusDays(numberOfDays);
    }

}
