package com.github.giulioscattolin.temporal.offset;

import java.time.ZonedDateTime;

import static java.lang.Math.round;
import static java.time.temporal.ChronoUnit.NANOS;

class EpochAndTemporalOffset implements TemporalCoordinate {
    private final ZonedDateTime itsEpoch;
    private final TemporalOffset itsOffset;

    EpochAndTemporalOffset(ZonedDateTime epoch, TemporalOffset offset) {
        itsEpoch = epoch;
        itsOffset = offset;
    }

    public TemporalOffset until(TemporalCoordinate other) {
        return until((EpochAndTemporalOffset) other);
    }

    private TemporalOffset until(EpochAndTemporalOffset other) {
        long nanosecondsUntilOtherEpoch = this.itsEpoch.until(other.itsEpoch, NANOS);
        return other.itsOffset.minus(this.itsOffset).plusNanoseconds(nanosecondsUntilOtherEpoch);
    }

    public TemporalOffset since(TemporalCoordinate other) {
        return other.until(this);
    }

    public TemporalCoordinate plus(TemporalOffset offset) {
        return new EpochAndTemporalOffset(itsEpoch, itsOffset.plus(offset));
    }

    public TemporalCoordinate minus(TemporalOffset offset) {
        return new EpochAndTemporalOffset(itsEpoch, itsOffset.minus(offset));
    }

    public ZonedDateTime toZonedDateTime() {
        long fullSeconds = (long) itsOffset.toSeconds();
        long fullNanoseconds = round(itsOffset.minusSeconds(fullSeconds).toNanoseconds());
        return itsEpoch.plusSeconds(fullSeconds).plusNanos(fullNanoseconds);
    }
}
