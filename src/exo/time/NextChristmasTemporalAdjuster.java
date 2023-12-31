package exo.time;

import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * Custom TemporalAdjuster;
 * Example to implement TemporalAdjuster to move a date to next Christmas
 */
public class NextChristmasTemporalAdjuster implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.MONTH_OF_YEAR,12).with(ChronoField.DAY_OF_MONTH,25);
    }
}