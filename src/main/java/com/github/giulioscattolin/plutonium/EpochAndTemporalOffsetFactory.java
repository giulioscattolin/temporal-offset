package com.github.giulioscattolin.plutonium;

import java.time.ZonedDateTime;

public class EpochAndTemporalOffsetFactory implements TemporalCoordinateFactory {
    private final TemporalOffsetFactory itsOffsetFactory;

    public EpochAndTemporalOffsetFactory(TemporalOffsetFactory offsetFactory) {
        itsOffsetFactory = offsetFactory;
    }

    public TemporalCoordinate from(ZonedDateTime zonedDateTime) {
        return new EpochAndTemporalOffset(zonedDateTime, itsOffsetFactory.zero());
    }
}
