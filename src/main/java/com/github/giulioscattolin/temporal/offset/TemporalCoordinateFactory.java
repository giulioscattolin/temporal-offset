package com.github.giulioscattolin.temporal.offset;

import java.time.ZonedDateTime;

public interface TemporalCoordinateFactory {
    TemporalCoordinate from(ZonedDateTime zonedDateTime);
}
