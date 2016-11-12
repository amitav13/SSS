package com.s3.s3;

public enum IndianStates {

    SelectState("Select your state", 0.0),
    AndhraPradesh("Andhra Pradesh", 8.0),
    Delhi("New Delhi", 7.0),
    Gujarat("Gujarat", 4.95),
    Haryana("Haryana", 6.2),
    Karnataka("Karnataka", 6.62),
    Maharashtra("Maharashtra", 10.33);

    private final String name;
    private final double pricePerUnit;

    IndianStates(String name, double pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString(){
        return name;
    }
}
