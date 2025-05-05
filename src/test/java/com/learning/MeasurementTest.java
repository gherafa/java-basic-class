package com.learning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class MeasurementTest {
    @Test
    void equals_shouldFullfillEqualsContract_whenInvoke() {
        EqualsVerifier.simple().forClass(Measurement.class).verify();
    }

    @Test
    void equals_shouldReturnTrue_whenGivenSameObject() {
        Measurement lengthInMeter = new Measurement(1.0, Unit.METER);

        assertEquals(lengthInMeter, lengthInMeter);
    }

    @Test
    void notEquals_shouldReturnTrue_whenGivenAnotherMeasurementIsInString() {
        Measurement lengthInMeter = new Measurement(1.0, Unit.METER);
        String lengthInString = "1.0";
        // System.out.println(lengthInMeter.toString());

        assertNotEquals(lengthInMeter,lengthInString);
    }

    @Test
    void equals_shouldReturnTrue_whenGivenMeasurementis1MeterAndAnotherMeasurementIs100CM() {
        Measurement lengthInMeter = new Measurement(1.0, Unit.METER);
        Measurement lengthInCm = new Measurement(100, Unit.CENTIMETER);

        assertEquals(lengthInCm, lengthInMeter);
    }

    @Test
    void add_shouldReturn2KM_whenGivenMeasurementIs1000MandOtherMeasurementIs1KM() {
        Measurement measurement = new Measurement(1.0, Unit.KILOMETER);
        Measurement otheMeasurement = new Measurement(1000.0, Unit.METER);
        Measurement expectedResult = new Measurement(2.0, Unit.KILOMETER);

        Measurement actualResult = measurement.add(otheMeasurement);

        assertEquals(expectedResult, actualResult);
    }
}