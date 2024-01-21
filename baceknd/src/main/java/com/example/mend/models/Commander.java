package com.example.mend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "commander")
public class Commander extends Alien {

    @Column(name = "vehicle")
    private String vehicle;

    @Column(name = "commander_id")
    private Long commanderId;

    public Commander() {}

    public Commander(String name, String vehicle, Long commanderId) {
        super(name);
        this.vehicle = vehicle;
        this.commanderId = commanderId;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Long getCommanderId() {
        return commanderId;
    }

    public void setCommanderId(Long commanderId) {
        this.commanderId = commanderId;
    }
}
