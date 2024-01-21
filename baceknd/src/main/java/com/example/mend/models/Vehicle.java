package com.example.mend.models;

public enum Vehicle {
    BIRD_SCOOTER("Bird scooter"),
    MERKAVA_TANK("Merkava tank"),
    EGGED_BUS("Egged Bus");

    private final String value;

    Vehicle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

