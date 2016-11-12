package com.s3.s3;

/**
 * Created by Amitav on 11/12/2016.
 */

public enum Panel {

    CanadianSolar("CanadianSolar"),
    VikramEldora("VikramEldora"),
    Sonali("Sonali");

    final String name;

    Panel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
