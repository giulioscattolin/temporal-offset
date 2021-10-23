package com.github.giulioscattolin.temporal.offset;

import java.time.ZonedDateTime;

/**
 * Represents a single point in time.
 */
public interface TemporalCoordinate {
    TemporalOffset until(TemporalCoordinate other);

    TemporalOffset since(TemporalCoordinate other);

    TemporalCoordinate plus(TemporalOffset offset);

    TemporalCoordinate minus(TemporalOffset offset);

    ZonedDateTime toZonedDateTime();
}
