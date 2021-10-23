package com.github.giulioscattolin.plutonium;

import java.math.BigDecimal;
import java.util.Objects;

class BigDecimalTemporalOffset implements TemporalOffset {
    private static final long NANOSECONDS_IN_SECOND = 1_000_000_000L;
    private static final int SECONDS_IN_MINUTES = 60;
    private static final int MINUTES_IN_HOUR = 60;
    private static final int HOURS_IN_DAY = 24;
    private static final int DAYS_IN_WEEK = 7;
    private static final long HOURS_IN_WEEK = HOURS_IN_DAY * DAYS_IN_WEEK;
    private static final long MINUTES_IN_WEEK = MINUTES_IN_HOUR * HOURS_IN_WEEK;
    private static final long MINUTES_IN_DAY = MINUTES_IN_HOUR * HOURS_IN_DAY;
    private static final long SECONDS_IN_WEEK = SECONDS_IN_MINUTES * MINUTES_IN_WEEK;
    private static final long SECONDS_IN_DAY = SECONDS_IN_MINUTES * MINUTES_IN_DAY;
    private static final long NANOSECONDS_IN_WEEK = NANOSECONDS_IN_SECOND * SECONDS_IN_WEEK;
    private static final long NANOSECONDS_IN_DAY = NANOSECONDS_IN_SECOND * SECONDS_IN_DAY;
    private final BigDecimal itsNanoseconds;

    BigDecimalTemporalOffset(BigDecimal bigDecimal) {
        itsNanoseconds = bigDecimal;
    }

    public double toSeconds() {
        return toNanoseconds() / NANOSECONDS_IN_SECOND;
    }

    public double toNanoseconds() {
        return itsNanoseconds.doubleValue();
    }

    public TemporalOffset plus(TemporalOffset other) {
        BigDecimalTemporalOffset otherBigDecimal = (BigDecimalTemporalOffset) other;
        return new BigDecimalTemporalOffset(itsNanoseconds.add(otherBigDecimal.itsNanoseconds));
    }

    public TemporalOffset minus(TemporalOffset other) {
        BigDecimalTemporalOffset otherBigDecimal = (BigDecimalTemporalOffset) other;
        return new BigDecimalTemporalOffset(itsNanoseconds.subtract(otherBigDecimal.itsNanoseconds));
    }

    public boolean isLessThan(TemporalOffset other) {
        BigDecimalTemporalOffset otherBigDecimal = (BigDecimalTemporalOffset) other;
        return this.itsNanoseconds.compareTo(otherBigDecimal.itsNanoseconds) < 0;
    }

    public boolean isGreaterThan(TemporalOffset other) {
        BigDecimalTemporalOffset otherBigDecimal = (BigDecimalTemporalOffset) other;
        return this.itsNanoseconds.compareTo(otherBigDecimal.itsNanoseconds) > 0;
    }

    public TemporalOffset plusWeeks(long weeks) {
        return plusDays(DAYS_IN_WEEK * weeks);
    }

    public TemporalOffset minusWeeks(long weeks) {
        return minusDays(DAYS_IN_WEEK * weeks);
    }

    public TemporalOffset plusDays(long days) {
        return plusHours(HOURS_IN_DAY * days);
    }

    public TemporalOffset minusDays(long days) {
        return minusHours(HOURS_IN_DAY * days);
    }

    public TemporalOffset plusHours(long hours) {
        return plusMinutes(MINUTES_IN_HOUR * hours);
    }

    public TemporalOffset minusHours(long hours) {
        return minusMinutes(MINUTES_IN_HOUR * hours);
    }

    public TemporalOffset plusMinutes(long minutes) {
        return plusSeconds(SECONDS_IN_MINUTES * minutes);
    }

    public TemporalOffset minusMinutes(long minutes) {
        return minusSeconds(SECONDS_IN_MINUTES * minutes);
    }

    public TemporalOffset plusSeconds(long seconds) {
        return plusNanoseconds(NANOSECONDS_IN_SECOND * seconds);
    }

    public TemporalOffset minusSeconds(long seconds) {
        return minusNanoseconds(NANOSECONDS_IN_SECOND * seconds);
    }

    public TemporalOffset plusSeconds(double seconds) {
        return plusNanoseconds(NANOSECONDS_IN_SECOND * seconds);
    }

    public TemporalOffset minusSeconds(double seconds) {
        return minusNanoseconds(NANOSECONDS_IN_SECOND * seconds);
    }

    public TemporalOffset plusNanoseconds(long nanoseconds) {
        return new BigDecimalTemporalOffset(itsNanoseconds.add(new BigDecimal(nanoseconds)));
    }

    public TemporalOffset minusNanoseconds(long nanoseconds) {
        return plusNanoseconds(-nanoseconds);
    }

    public TemporalOffset plusNanoseconds(double nanoseconds) {
        return new BigDecimalTemporalOffset(itsNanoseconds.add(new BigDecimal(nanoseconds)));
    }

    public TemporalOffset minusNanoseconds(double nanoseconds) {
        return plusNanoseconds(-nanoseconds);
    }

    public TemporalOffset atTheBeginningOfTheWeek() {
        long weeks = itsNanoseconds.longValue() / NANOSECONDS_IN_WEEK;
        return new BigDecimalTemporalOffset(new BigDecimal(NANOSECONDS_IN_WEEK * weeks));
    }

    public TemporalOffset atTheBeginningOfTheDay() {
        long days = itsNanoseconds.longValue() / NANOSECONDS_IN_DAY;
        return new BigDecimalTemporalOffset(new BigDecimal(NANOSECONDS_IN_DAY * days));
    }

    public TemporalOffset sinceTheBeginningOfTheWeek() {
        long weeks = itsNanoseconds.longValue() / NANOSECONDS_IN_WEEK;
        return minusWeeks(weeks);
    }

    public TemporalOffset sinceTheBeginningOfTheDay() {
        long days = itsNanoseconds.longValue() / NANOSECONDS_IN_DAY;
        return minusDays(days);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BigDecimalTemporalOffset that = (BigDecimalTemporalOffset) o;
        return itsNanoseconds.equals(that.itsNanoseconds);
    }

    public int hashCode() {
        return Objects.hash(itsNanoseconds);
    }

    public String toString() {
        return "BigDecimalTemporalOffset{" +
            "itsNanoseconds=" + itsNanoseconds +
            '}';
    }
}
