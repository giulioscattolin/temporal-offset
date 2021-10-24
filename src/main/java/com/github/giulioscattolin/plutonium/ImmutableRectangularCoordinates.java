package com.github.giulioscattolin.plutonium;

public class ImmutableRectangularCoordinates implements RectangularCoordinates {
    private final double itsX;
    private final double itsY;
    private final double itsZ;

    public ImmutableRectangularCoordinates(double x, double y, double z) {
        itsX = x;
        itsY = y;
        itsZ = z;
    }

    public double getX() {
        return itsX;
    }

    public double getY() {
        return itsY;
    }

    public double getZ() {
        return itsZ;
    }
}
