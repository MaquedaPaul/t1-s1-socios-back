package ar.utn.aceleradora.gestion.socios.converters;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//convert a string to localDate
public class DateConverter {

    public static LocalDate parse(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha no válido: " + dateString);
        }
    }
    public static LocalTime parseDateTime(String dateTime){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            return LocalTime.parse(dateTime, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha no válido: " + dateTime);
        }
    }


}
