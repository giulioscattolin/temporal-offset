package com.github.giulioscattolin.plutonium;

public interface ECEFCoordinates {
    RectangularCoordinates getRectangularCoordinates();

    TemporalCoordinate getTemporalCoordinate();

    ECEFCoordinates withTemporalCoordinate(TemporalCoordinate newTemporalCoordinate);
}
