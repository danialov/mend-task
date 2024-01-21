package com.example.mend.dtos;

public class AlienDTO {
    private String type;
    private Long id;
    private String name;
    private String vehicle;
    private String weapon;
    private Long commanderId;
    private String commanderName;
    public AlienDTO(String type, Long id, String name, String vehicle, String weapon, Long commanderId, String commanderName) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.vehicle = vehicle;
        this.weapon = weapon;
        this.commanderId = commanderId;
        this.commanderName = commanderName;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public Long getCommanderId() {
        return commanderId;
    }

    public void setCommanderId(Long commanderId) {
        this.commanderId = commanderId;
    }

    public String getCommanderName() {
        return commanderName;
    }

    public void setCommanderName(String commanderName) {
        this.commanderName = commanderName;
    }
}