package exo.time;

import java.time.*;
import java.util.Date;

/**
 * https://mkyong.com/java8/java-8-convert-date-to-localdate-and-localdatetime/
 */
public class ConvertDateUtilToLocale {

    public static void main(String[] args) {
        Date utilDate = new Date();
        LocalDate localDate = convertUtilDateToLocalDate(utilDate);
        LocalDate localDate2 = convertUtilDateMstoLocalDate(utilDate.getTime());

        LocalDateTime localDateTime = convertUtilDateToLocalDateTime(utilDate);

        ZonedDateTime zonedDateTime = convertUtilDateToZonedDateTime(utilDate);


    }

    public static ZonedDateTime convertUtilDateToZonedDateTime(Date utilDate) {
        ZonedDateTime zonedDateTime = utilDate.toInstant().atZone(ZoneId.systemDefault());
        return zonedDateTime;
    }

    private static LocalDate convertUtilDateMstoLocalDate(long utilDateMs) {
        // different way of create instant object (depuis date.getTime())
        return Instant.ofEpochMilli(utilDateMs).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private static LocalDateTime convertUtilDateToLocalDateTime(Date utilDate) {
        return utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private static LocalDate convertUtilDateToLocalDate(Date utilDate) {
        return utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
