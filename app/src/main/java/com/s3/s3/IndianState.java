package com.s3.s3;

public enum IndianState {

    SelectState("Select your state", 0.0, 0.0),
    AndhraPradesh("Andhra Pradesh", 8.0, 4.2),
    Delhi("New Delhi", 7.0, 3.8),
    Gujarat("Gujarat", 4.95, 4.3),
    Haryana("Haryana", 6.2, 3.8),
    Karnataka("Karnataka", 6.62, 4.2),
    Maharashtra("Maharashtra", 10.33, 4.2);

    final String name;
    final double pricePerUnit;
    final double avgIrradiation;

    IndianState(String name, double pricePerUnit, double avgIrradiation) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.avgIrradiation = avgIrradiation;
    }

    @Override
    public String toString(){
        return name;
    }
}
