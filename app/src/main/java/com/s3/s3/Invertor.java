package com.s3.s3;

/**
 * Created by Amitav on 11/12/2016.
 */

public enum Invertor {

    SMA("SMA"),
    Fronius("Fronius"),
    Growatt("Growatt");

    final String name;

    Invertor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
