package com.github.giulioscattolin.plutonium;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class ImmutableECEFCoordinates implements ECEFCoordinates {
    private static final double EARTH_ROTATION_RATE = 0;
    private final RectangularCoordinates itsRectangularCoordinates;
    private final TemporalCoordinate itsTemporalCoordinate;

    public ImmutableECEFCoordinates(RectangularCoordinates rectangularCoordinates, TemporalCoordinate temporalCoordinate) {
        itsRectangularCoordinates = rectangularCoordinates;
        itsTemporalCoordinate = temporalCoordinate;
    }

    public RectangularCoordinates getRectangularCoordinates() {
        return itsRectangularCoordinates;
    }

    public TemporalCoordinate getTemporalCoordinate() {
        return itsTemporalCoordinate;
    }

    public ECEFCoordinates withTemporalCoordinate(TemporalCoordinate newTemporalCoordinate) {
        double secondsUntilNewTemporalCoordinate = itsTemporalCoordinate.until(newTemporalCoordinate).toSeconds();
        double rotationAngleInRadians = EARTH_ROTATION_RATE * secondsUntilNewTemporalCoordinate;
        RectangularCoordinates newRectangularCoordinates = rotateBy(rotationAngleInRadians);
        return new ImmutableECEFCoordinates(newRectangularCoordinates, newTemporalCoordinate);
    }

    private RectangularCoordinates rotateBy(double rotationAngleInRadians) {
        double x = itsRectangularCoordinates.getX();
        double y = itsRectangularCoordinates.getY();
        double z = itsRectangularCoordinates.getZ();
        double newX = x * cos(rotationAngleInRadians) - y * sin(rotationAngleInRadians);
        double newY = x * sin(rotationAngleInRadians) + y * cos(rotationAngleInRadians);
        double newZ = z;
        return new ImmutableRectangularCoordinates(newX, newY, newZ);
    }
}
