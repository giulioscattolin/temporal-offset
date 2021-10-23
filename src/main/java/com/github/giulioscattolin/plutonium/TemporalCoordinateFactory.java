package com.github.giulioscattolin.plutonium;

import java.time.ZonedDateTime;

public interface TemporalCoordinateFactory {
    TemporalCoordinate from(ZonedDateTime zonedDateTime);
}
