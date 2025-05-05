package com.learning;

import java.util.Objects;

public class Measurement {
  protected final double value;
  protected final Unit unit;

  public Measurement(double value, Unit unit) {
    this.value = value;
    this.unit = unit;
  }

  @Override
  public final boolean equals(Object object) {
    final double EQUALS=0;

    if (this == object) {
      return true;
    }

    if (!(object instanceof Measurement)) {
      return false;
    }

    Measurement otherMeasurement = (Measurement) object;
    if (this.unit == otherMeasurement.unit && this.value == otherMeasurement.value) {
      return true;
    }
    if (this.unit == null || otherMeasurement.unit == null) {
      return false;
    }
    return Double.compare((this.unit.toStandarInternationalsValue(otherMeasurement)),
      otherMeasurement.unit.toStandarInternationalsValue(this)) == EQUALS;
  }

  @Override
  public final int hashCode() {
    if (this.unit != null) {
      return Objects.hash(this.unit.toStandarInternationalsValue(this));
    }

    return Objects.hash(this.value);
  }

  @Override
  public String toString() {
    return "Length [unit = " + unit + ", value = " + value + "]"; 
  }

  public Measurement add(Measurement otherMeasurement) {
    double addResult = this.value + this.unit.convertValueOf(otherMeasurement);

    return new Measurement(addResult, this.unit);
  }
}
