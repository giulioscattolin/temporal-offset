package com.github.giulioscattolin.temporal.offset;

import org.junit.Before;
import org.junit.Test;

import java.time.ZonedDateTime;

import static com.google.common.truth.Truth.assertThat;
import static java.time.ZonedDateTime.now;

public class EpochAndTemporalOffsetFactoryTest {
    TemporalCoordinateFactory itsCoordinateFactory;
    TemporalOffsetFactory itsOffsetFactory;
    ZonedDateTime itsTime;
    TemporalCoordinate itsPresent;
    TemporalCoordinate itsFuture;

    @Before
    public void setup() {
        itsOffsetFactory = new BigDecimalTemporalOffsetFactory();
        itsCoordinateFactory = new EpochAndTemporalOffsetFactory(itsOffsetFactory);
        itsTime = now();
    }

    @Test
    public void verifyZero() {
        itsPresent = itsCoordinateFactory.from(itsTime);
        itsFuture = itsCoordinateFactory.from(itsTime);

        assertThat(itsPresent.until(itsFuture).toSeconds()).isEqualTo(0.0);
        assertThat(itsFuture.since(itsPresent).toSeconds()).isEqualTo(0.0);
        assertThat(itsPresent.toZonedDateTime()).isEqualTo(itsTime);
        assertThat(itsFuture.toZonedDateTime()).isEqualTo(itsTime);
    }

    @Test
    public void verifyPlus() {
        itsPresent = itsCoordinateFactory.from(itsTime);
        itsFuture = itsPresent.plus(getZero().plusSeconds(1));

        assertThat(itsPresent.until(itsFuture).toSeconds()).isEqualTo(1.0);
        assertThat(itsFuture.since(itsPresent).toSeconds()).isEqualTo(1.0);
        assertThat(itsPresent.toZonedDateTime()).isEqualTo(itsTime);
        assertThat(itsFuture.toZonedDateTime()).isEqualTo(itsTime.plusSeconds(1));
    }

    @Test
    public void verifyMinus() {
        itsFuture = itsCoordinateFactory.from(itsTime);
        itsPresent = itsFuture.minus(getZero().plusSeconds(1));

        assertThat(itsPresent.until(itsFuture).toSeconds()).isEqualTo(1.0);
        assertThat(itsFuture.since(itsPresent).toSeconds()).isEqualTo(1.0);
        assertThat(itsPresent.toZonedDateTime()).isEqualTo(itsTime.minusSeconds(1));
        assertThat(itsFuture.toZonedDateTime()).isEqualTo(itsTime);
    }

    private TemporalOffset getZero() {
        return itsOffsetFactory.zero();
    }
}