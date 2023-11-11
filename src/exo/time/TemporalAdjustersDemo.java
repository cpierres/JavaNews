package exo.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersDemo {
    public static void main(String[] args) {

        System.out.println("Example to move a date to firstDayOfMonth, firstDayOfNextMonth, next Monday and etc");
        LocalDate localDate = LocalDate.now();
        System.out.println("current date : " + localDate);

        LocalDate with = localDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("firstDayOfMonth : " + with);

        LocalDate with1 = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("lastDayOfMonth : " + with1);

        LocalDate with2 = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("next monday : " + with2);

        LocalDate with3 = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("firstDayOfNextMonth : " + with3);

    }
}