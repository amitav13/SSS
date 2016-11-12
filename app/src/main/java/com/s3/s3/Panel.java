package com.s3.s3;

/**
 * Created by Amitav on 11/12/2016.
 */

public enum Panel {

    CanadianSolar("CanadianSolar", "Canadian Solar : Tier 1 Modules. 16.7% efficiency, Manufactured in China. One of the top Tier 1 modules in the world."),
    VikramEldora("VikramEldora", "Vikram Eldora : Tier 1 Modules. 15.99% efficiency, Manufactured in India. Production is lower as compared to other Tier 1 modules."),
    Sonali("Sonali", "Sonali : Tier 2 Modules. 14.85% efficiency, Manufactured in India. Production is lower as compared to Tier 1 modules.\n");

    final String name;
    final String comment;

    Panel(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return name;
    }
}
