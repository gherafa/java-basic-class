package com.learning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class UnitTest {
    @Test
    void isUnitTypeEquals_shouldReturnTrue_whenGivenMeasurementIsLenght() {
        assertTrue(Unit.CENTIMETER.isUnitTypeEquals(Unit.METER));
    }

    @Test
    void toStandardInternationalValue_shouldReturn1_whenGivenMeasurement100Cm() {
        Measurement measurement = new Measurement(100.0, Unit.CENTIMETER);
        double expectedResult = 1.0;

        assertEquals(expectedResult, measurement.unit.toStandarInternationalsValue(measurement));
    }

    @Test
    void toStandardInternationalValue_shouldReturn1000_whenGivenMeasurement1Km() {
        Measurement measurement = new Measurement(1.0, Unit.KILOMETER);
        double expectedResult = 1000.0;

        assertEquals(expectedResult, measurement.unit.toStandarInternationalsValue(measurement));
    }

    @Test
    void convertValueOf_shouldReturn1000M_whenGivenMeasurementIs1Km() {
        Measurement measurement = new Measurement(1.0, Unit.KILOMETER);
        double expectedResult = 1000.0;

        double actualResult = Unit.METER.convertValueOf(measurement);

        assertEquals(expectedResult, actualResult);
    }
}