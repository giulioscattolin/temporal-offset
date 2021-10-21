package com.github.giulioscattolin.temporal.offset;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class BigDecimalTemporalOffsetFactoryTest {
    TemporalOffsetFactory itsFactory;

    @Before
    public void setup() {
        itsFactory = new BigDecimalTemporalOffsetFactory();
    }

    @Test
    public void verifyNullOffsetEqualsToZeroSeconds() {
        assertThat(itsFactory.zero().toSeconds()).isEqualTo(0);
    }

    @Test
    public void verifyNullOffsetEqualsToZeroNanoseconds() {
        assertThat(itsFactory.zero().toNanoseconds()).isEqualTo(0);
    }

    @Test
    public void verifyToNanoseconds() {
        assertThat(itsFactory.zero().plusNanoseconds(0).toNanoseconds()).isEqualTo(0);
        assertThat(itsFactory.zero().plusNanoseconds(1).toNanoseconds()).isEqualTo(1);
        assertThat(itsFactory.zero().minusNanoseconds(1).toNanoseconds()).isEqualTo(-1);
    }

    @Test
    public void verifyToSeconds() {
        assertThat(itsFactory.zero().plusSeconds(0).toSeconds()).isEqualTo(0);
        assertThat(itsFactory.zero().plusSeconds(1).toSeconds()).isEqualTo(1);
        assertThat(itsFactory.zero().minusSeconds(1).toSeconds()).isEqualTo(-1);
    }

    @Test
    public void verifySeconds() {
        assertThat(itsFactory.zero().plusSeconds(0).plus(itsFactory.zero().plusSeconds(0))).isEqualTo(itsFactory.zero().plusSeconds(0));
        assertThat(itsFactory.zero().plusSeconds(1).plus(itsFactory.zero().plusSeconds(0))).isEqualTo(itsFactory.zero().plusSeconds(1));
        assertThat(itsFactory.zero().plusSeconds(0).plus(itsFactory.zero().plusSeconds(1))).isEqualTo(itsFactory.zero().plusSeconds(1));

        assertThat(itsFactory.zero().plusSeconds(0).minus(itsFactory.zero().plusSeconds(0))).isEqualTo(itsFactory.zero().plusSeconds(0));
        assertThat(itsFactory.zero().plusSeconds(1).minus(itsFactory.zero().plusSeconds(0))).isEqualTo(itsFactory.zero().plusSeconds(1));
        assertThat(itsFactory.zero().plusSeconds(0).minus(itsFactory.zero().plusSeconds(1))).isEqualTo(itsFactory.zero().plusSeconds(-1));

        assertThat(itsFactory.zero().plusSeconds(1.234).toNanoseconds()).isEqualTo(1.234E9);
        assertThat(itsFactory.zero().minusSeconds(1.234).toNanoseconds()).isEqualTo(-1.234E9);
    }

    @Test
    public void verifyGreaterThan() {
        assertThat(itsFactory.zero().plusSeconds(0).isGreaterThan(itsFactory.zero().plusSeconds(0))).isFalse();
        assertThat(itsFactory.zero().plusSeconds(1).isGreaterThan(itsFactory.zero().plusSeconds(0))).isTrue();
        assertThat(itsFactory.zero().plusSeconds(0).isGreaterThan(itsFactory.zero().plusSeconds(1))).isFalse();
    }

    @Test
    public void verifyLessThan() {
        assertThat(itsFactory.zero().plusSeconds(0).isLessThan(itsFactory.zero().plusSeconds(0))).isFalse();
        assertThat(itsFactory.zero().plusSeconds(1).isLessThan(itsFactory.zero().plusSeconds(0))).isFalse();
        assertThat(itsFactory.zero().plusSeconds(0).isLessThan(itsFactory.zero().plusSeconds(1))).isTrue();
    }

    @Test
    public void verifyPlusWeeks() {
        assertThat(itsFactory.zero().plusWeeks(1).toSeconds()).isEqualTo(604800);
    }

    @Test
    public void verifyMinusWeeks() {
        assertThat(itsFactory.zero().minusWeeks(1).toSeconds()).isEqualTo(-604800);
    }

    @Test
    public void verifyPlusDays() {
        assertThat(itsFactory.zero().plusDays(1).toNanoseconds()).isEqualTo(86_400_000_000_000.0);
    }

    @Test
    public void verifyMinusDays() {
        assertThat(itsFactory.zero().minusDays(1).toNanoseconds()).isEqualTo(-86_400_000_000_000.0);
    }

    @Test
    public void verifySinceTheBeginningOfTheDay() {
        assertThat(itsFactory.zero().plusDays(0).plusSeconds(0).sinceTheBeginningOfTheDay()).isEqualTo(itsFactory.zero().plusSeconds(0));
        assertThat(itsFactory.zero().plusDays(0).plusSeconds(1).sinceTheBeginningOfTheDay()).isEqualTo(itsFactory.zero().plusSeconds(1));
        assertThat(itsFactory.zero().plusDays(1).plusSeconds(1).sinceTheBeginningOfTheDay()).isEqualTo(itsFactory.zero().plusSeconds(1));
    }

    @Test
    public void verifySinceTheBeginningOfTheWeek() {
        assertThat(itsFactory.zero().plusWeeks(0).plusSeconds(0).sinceTheBeginningOfTheWeek()).isEqualTo(itsFactory.zero().plusSeconds(0));
        assertThat(itsFactory.zero().plusWeeks(0).plusSeconds(1).sinceTheBeginningOfTheWeek()).isEqualTo(itsFactory.zero().plusSeconds(1));
        assertThat(itsFactory.zero().plusWeeks(1).plusSeconds(1).sinceTheBeginningOfTheWeek()).isEqualTo(itsFactory.zero().plusSeconds(1));
    }

    @Test
    public void verifyAtTheBeginningOfTheDay() {
        assertThat(itsFactory.zero().plusDays(0).plusSeconds(0).atTheBeginningOfTheDay()).isEqualTo(itsFactory.zero().plusDays(0));
        assertThat(itsFactory.zero().plusDays(1).plusSeconds(0).atTheBeginningOfTheDay()).isEqualTo(itsFactory.zero().plusDays(1));
        assertThat(itsFactory.zero().plusDays(1).plusSeconds(1).atTheBeginningOfTheDay()).isEqualTo(itsFactory.zero().plusDays(1));
    }

    @Test
    public void verifyAtTheBeginningOfTheWeek() {
        assertThat(itsFactory.zero().plusWeeks(0).plusSeconds(0).atTheBeginningOfTheWeek()).isEqualTo(itsFactory.zero().plusWeeks(0));
        assertThat(itsFactory.zero().plusWeeks(1).plusSeconds(0).atTheBeginningOfTheWeek()).isEqualTo(itsFactory.zero().plusWeeks(1));
        assertThat(itsFactory.zero().plusWeeks(1).plusSeconds(1).atTheBeginningOfTheWeek()).isEqualTo(itsFactory.zero().plusWeeks(1));
    }

    @Test
    public void verifyPrecisionIsNotLostEvenForHugeOffsets() {
        assertThat(
            itsFactory.zero()
                .plusWeeks(1_000_000L)
                .plusSeconds(345)
                .plusNanoseconds(0.123456789)
                .minusWeeks(1_000_000L)
                .minusSeconds(345)
                .minusNanoseconds(0.123456788)
                .toNanoseconds()
        ).isWithin(
            1E-12
        ).of(
            1E-9
        );
    }
}