package com.github.giulioscattolin.plutonium;

import java.math.BigDecimal;

public class BigDecimalTemporalOffsetFactory implements TemporalOffsetFactory {
    public TemporalOffset zero() {
        return new BigDecimalTemporalOffset(BigDecimal.ZERO);
    }
}
