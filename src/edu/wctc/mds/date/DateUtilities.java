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
     * @return the current dateTimeFormat structure when called
     */
    public final DateTimeFormatter getDateTimeFormat() {
        return dateTimeFormat;
    }

    /**
     * Method sets the format of the DateTimeFormatter property when called and
     * provided valid dateTimeFormat.
     * @param dateTimeFormat a <code>DateTimeFormatter</code> object
     * @throws IllegalArgumentException - if format is null
     */
    public final void setDateTimeFormat(DateTimeFormatter dateTimeFormat) throws IllegalArgumentException {
        if (dateTimeFormat == null) {
            throw new IllegalArgumentException("No or invlaid format provided");
        }
        this.dateTimeFormat = dateTimeFormat;
    }

    /**
     * Parse the LocalDateTime object to a String and formats the string based
     * upon the format provided.
     * @param date a <code>LocalDateTime</code> object
     * @param format a <code>DateTimeFormatter</code> object
     * @return LocalDateTime formatted as a string according to the pattern from
     * the DateTimeFormatter
     * @throws IllegalArgumentException - if date or format is null
     */
    public final String toString(LocalDateTime date, DateTimeFormatter format) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("No date provided");
        }
        setDateTimeFormat(format);
        String stringDate = date.format(dateTimeFormat);
        return stringDate;
    }

    /**
     * Converts a string date to a Local Date Time, formatted according to the
     * DateTimeFormatter
     * @param stringDate a <code>string</code> date value
     * @param format a <code>DateTimeFormatter</code> object
     * @return the string parsed as a LocalDateTime object
     * @throws IllegalArgumentException - if the string date is null or length
     * is less than 0 or if the format is null
     */
    public final LocalDateTime toLocalDateTime(String stringDate, DateTimeFormatter format) throws IllegalArgumentException {
        if (stringDate == null || stringDate.length() == 0) {
            throw new IllegalArgumentException("Please provide a date");
        }
        setDateTimeFormat(format);
        LocalDateTime dateTime = LocalDateTime.parse(stringDate, dateTimeFormat);
        return dateTime;
    }

    /**
     * Calculates the time between two days in minutes
     * @param startDateTime a <code>LocalDateTime</code> object
     * @param endDateTime a <code>LocalDateTime</code> object
     * @return difference in time between two dates in minutes
     * @throws IllegalArgumentException if either of the two dates are null
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
     * Calculates the difference in time between two dates in number hours
     * @param startDateTime a <code>LocalDateTime</code> object
     * @param endDateTime a <code>LocalDateTime</code> object
     * @return difference in time between two dates in hours
     * @throws IllegalArgumentException if either of the two dates are null
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
     * Calculate the difference between two dates in the number of days
     * @param startDateTime a <code>LocalDateTime</code> object
     * @param endDateTime a <code>LocalDateTime</code> object
     * @return number of days between two days
     * @throws IllegalArgumentException if either of the two dates are null
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
     * Gets the future LocalDate from the current date, based upon how many days
     * it should be from the current date
     * @param numberOfDays - an <code>int</code> value for number of days from the current
     * date
     * @return future date from current date according
     * @throws IllegalArgumentException - if number of days is less than or
     * equal to 0
     */
    public final LocalDate getDateFromCurrentDate(int numberOfDays) throws IllegalArgumentException {
        LocalDate currentDate = LocalDate.now();
        if (numberOfDays <= 0) {
            throw new IllegalArgumentException("Number of days must be greater than 0");
        }
        return currentDate.plusDays(numberOfDays);
    }

    /**
     * Calculates the date in the past from the current date according to the
     * specified number of days passed
     * @param numberOfDays - <code>int</code> value for number of days prior to the current
     * date
     * @return the date prior to the current date
     * @throws IllegalArgumentException - if number of days is less than or
     * equal to 0
     */
    public final LocalDate getDatePriorToCurrentDate(int numberOfDays) throws IllegalArgumentException {
        LocalDate currentDate = LocalDate.now();
        if (numberOfDays <= 0) {
            throw new IllegalArgumentException("Number of days must be greater than 0");
        }
        return currentDate.minusDays(numberOfDays);
    }

    /**
     * Get the past date prior to the LocalDate provided according to the number 
     * of days from the LocalDate
     * @param date a <code>LocalDate</code> object
     * @param numberOfDays an <code>int</code> value for number of days
     * @return date minus the numbers of days 
     * @throws IllegalArgumentException - if date in null or if the number of 
     * days is less than or equal to 0
     */
    public final LocalDate getPastDate(LocalDate date, int numberOfDays) throws IllegalArgumentException{
        if (date == null) {
            throw new IllegalArgumentException("Invalid date provided");
        }
        if (numberOfDays <= 0) {
            throw new IllegalArgumentException("Number of days must be greater than 0");
        }
        return date.minusDays(numberOfDays);
    }

}
