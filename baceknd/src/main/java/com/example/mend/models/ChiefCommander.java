package com.example.mend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "chief_commander")
public class ChiefCommander extends Alien {

    @Column(name = "vehicle")
    private String vehicle;

    public ChiefCommander() {
    }

    public ChiefCommander(String name, String vehicle) {
        super(name);
        this.vehicle = vehicle;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}
