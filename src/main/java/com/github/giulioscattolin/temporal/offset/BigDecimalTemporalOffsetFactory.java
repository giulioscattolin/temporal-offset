package com.github.giulioscattolin.temporal.offset;

import java.math.BigDecimal;

public class BigDecimalTemporalOffsetFactory implements TemporalOffsetFactory {
    public TemporalOffset zero() {
        return new BigDecimalTemporalOffset(BigDecimal.ZERO);
    }
}
