package com.example.mend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "warrior")
public class Warrior extends Alien {

    @Column(name = "commander_id")
    private Long commanderId;

    @Column(name = "weapon")
    private String weapon;

    public Warrior() {
    }

    public Warrior(String name, Long commanderId, String weapon) {
        super(name);
        this.commanderId = commanderId;
        this.weapon = weapon;
    }

    public Long getCommanderId() {
        return commanderId;
    }

    public void setCommanderId(Long commanderId) {
        this.commanderId = commanderId;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}
