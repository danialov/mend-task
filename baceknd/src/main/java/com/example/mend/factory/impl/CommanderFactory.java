package com.example.mend.factory.impl;

import com.example.mend.dtos.AlienDTO;
import com.example.mend.factory.AlienFactory;
import com.example.mend.models.Alien;
import com.example.mend.models.Commander;
import org.springframework.stereotype.Service;

@Service
public class CommanderFactory implements AlienFactory {
    @Override
    public String getType() {
        return "Commander";
    }
    @Override
    public Alien createAlien(AlienDTO alienDTO) {
        Commander commander = new Commander();
        commander.setName(alienDTO.getName());
        if (alienDTO.getVehicle() != null && !alienDTO.getVehicle().isEmpty()) {
            commander.setVehicle(alienDTO.getVehicle());
        }
        commander.setCommanderId(alienDTO.getCommanderId());
        commander.setType("Commander");
        return commander;
    }
}
