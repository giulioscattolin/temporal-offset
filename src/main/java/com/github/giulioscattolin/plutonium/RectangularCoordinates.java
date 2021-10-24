package com.github.giulioscattolin.plutonium;

public interface RectangularCoordinates {
    double getX();

    double getY();

    double getZ();

    RectangularCoordinates minus(RectangularCoordinates other);

    RectangularCoordinates multiplyBy(double scale);

    RectangularCoordinates divideBy(double scale);
}
