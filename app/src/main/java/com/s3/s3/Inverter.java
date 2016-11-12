package com.s3.s3;

/**
 * Created by Amitav on 11/12/2016.
 */

public enum Inverter {

    SMA("SMA", "SMA : World leader in Solar inverters. 97.7% efficiency at peak load of 9 kW"),
    Fronius("Fronius", "Fronius : One of the best inverters. 96.02% efficiency at peak load of 10 kW"),
    Growatt("Growatt", "Growatt : One of the Leading Chinese inverters. 95.02% at peak load of 12 kW");

    final String name;
    final String comment;

    Inverter(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return name;
    }
}
