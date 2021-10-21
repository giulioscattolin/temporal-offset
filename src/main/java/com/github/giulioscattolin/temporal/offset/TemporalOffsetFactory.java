package com.github.giulioscattolin.temporal.offset;

/**
 * A factory of {@link TemporalOffset}s.
 */
public interface TemporalOffsetFactory {
    /**
     * Returns a zero temporal offset.
     */
    TemporalOffset zero();
}
