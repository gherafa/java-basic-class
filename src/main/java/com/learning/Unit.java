package com.learning;

public enum Unit {
  CENTIMETER(0.01, UnitType.LENGTH),
  METER(1.0, UnitType.LENGTH),
  KILOMETER(1000, UnitType.LENGTH);

  protected final double conversionRate;
  protected final UnitType unitType;

  private Unit(double conversionRate, UnitType unitType) {
    this.conversionRate = conversionRate;
    this.unitType = unitType;
  }

  public boolean isUnitTypeEquals(Unit otherUnit) {
    return this.unitType.equals(otherUnit.unitType);
  }

  public double toStandarInternationalsValue(Measurement measurement) {
    if (!isUnitTypeEquals(measurement.unit)) {
      throw new MissMatchTypeException();
    }

    return measurement.value * measurement.unit.conversionRate;
  }

  public double convertValueOf(Measurement measurement) {
    return measurement.unit.toStandarInternationalsValue(measurement) / this.conversionRate;
  }
}
