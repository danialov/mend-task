package com.example.mend.models;

public enum Weapon {
    WATER_GUN("Water gun"),
    PEPPER_SPRAY("Pepper spray"),
    CHOPSTICKS("Chopsticks");

    private final String value;

    Weapon(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

