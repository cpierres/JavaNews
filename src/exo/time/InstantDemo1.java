package exo.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Instant -> LocalDateTime<br>
 * The new Java 8 java.time.Instant is the equivalent class to the classic java.util.Date.<br>
 * The java.util.Date has no concept of time zone, and only represents the number of seconds passed
 * since the Unix epoch time – 1970-01-01T00:00:00Z (midnight at the start of January 1, 1970 GMT/UTC)
 */
public class InstantDemo1 {
    public static void main(String[] args) {
        //The java.time.LocalDateTime has no concept of time zone, just provide a zero offset UTC+0.
        Instant instant = Instant.now();

        System.out.println("Instant : " + instant);

        //Convert instant to LocalDateTime, no timezone, add a zero offset / UTC+0
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

        System.out.println("LocalDateTime : " + ldt);
    }
}
