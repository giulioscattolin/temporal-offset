package com.github.giulioscattolin.temporal.offset;

/**
 * Represents a temporal offset.
 */
public interface TemporalOffset {
    /**
     * Returns the value of this offset in seconds.
     */
    double toSeconds();

    /**
     * Returns the value of this offset in nanoseconds.
     */
    double toNanoseconds();

    /**
     * Returns the sum of this offset and the given one.
     */
    TemporalOffset plus(TemporalOffset other);

    /**
     * Returns the difference between this offset and the given one.
     */
    TemporalOffset minus(TemporalOffset other);

    /**
     * Returns <code>true</code> if this offset is less than the <code>other</code> one.
     */
    boolean isLessThan(TemporalOffset other);

    /**
     * Returns <code>true</code> if this offset is greater than the <code>other</code> one.
     */
    boolean isGreaterThan(TemporalOffset other);

    /**
     * Returns <code>true</code> if this offset is equal to the <code>other</code> one.
     */
    boolean isEqualTo(TemporalOffset other);

    /**
     * Returns an offset that is in the future by the given number of weeks.
     */
    TemporalOffset plusWeeks(long weeks);

    /**
     * Returns an offset that is in the past by the given number of weeks.
     */
    TemporalOffset minusWeeks(long weeks);

    /**
     * Returns an offset that is in the future by the given number of days.
     */
    TemporalOffset plusDays(long days);

    /**
     * Returns an offset that is in the past by the given number of days.
     */
    TemporalOffset minusDays(long days);

    /**
     * Returns an offset that is in the future by the given number of hours.
     */
    TemporalOffset plusHours(long hours);

    /**
     * Returns an offset that is in the past by the given number of hours.
     */
    TemporalOffset minusHours(long hours);

    /**
     * Returns an offset that is in the future by the given number of minutes.
     */
    TemporalOffset plusMinutes(long minutes);

    /**
     * Returns an offset that is in the past by the given number of minutes.
     */
    TemporalOffset minusMinutes(long minutes);

    /**
     * Returns an offset that is in the future by the given number of seconds.
     */
    TemporalOffset plusSeconds(long seconds);

    /**
     * Returns an offset that is in the past by the given number of seconds.
     */
    TemporalOffset minusSeconds(long seconds);

    /**
     * Returns an offset that is in the future by the given number of seconds.
     */
    TemporalOffset plusSeconds(double seconds);

    /**
     * Returns an offset that is in the past by the given number of seconds.
     */
    TemporalOffset minusSeconds(double seconds);

    /**
     * Returns an offset that is in the future by the given number of nanoseconds.
     */
    TemporalOffset plusNanoseconds(long nanoseconds);

    /**
     * Returns an offset that is in the past by the given number of nanoseconds.
     */
    TemporalOffset minusNanoseconds(long nanoseconds);

    /**
     * Returns an offset that is in the future by the given number of nanoseconds.
     */
    TemporalOffset plusNanoseconds(double nanoseconds);

    /**
     * Returns an offset that is in the past by the given number of nanoseconds.
     */
    TemporalOffset minusNanoseconds(double nanoseconds);

    /**
     * Returns an offset that is at the beginning of the current week.
     */
    TemporalOffset atTheBeginningOfTheWeek();

    /**
     * Returns an offset that is at the beginning of the current day.
     */
    TemporalOffset atTheBeginningOfTheDay();

    /**
     * Returns an offset that starts at the beginning of the current week.
     */
    TemporalOffset sinceTheBeginningOfTheWeek();

    /**
     * Returns an offset that starts at the beginning of the current day.
     */
    TemporalOffset sinceTheBeginningOfTheDay();
}
