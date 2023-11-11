package exo.time;

import java.time.LocalDate;

/**
 * La version d'une date sql vers LocalDate est directe
 */
public class ConvertDateSqlToLocalDate {

    public static void main(String[] args) {
        java.sql.Date sqlDate = java.sql.Date.valueOf("2020-02-05");
        LocalDate localDate2 = sqlDate.toLocalDate();
    }

}
