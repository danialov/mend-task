package com.example.mend.factory.impl;

import com.example.mend.dtos.AlienDTO;
import com.example.mend.factory.AlienFactory;
import com.example.mend.models.Alien;
import com.example.mend.models.ChiefCommander;
import org.springframework.stereotype.Service;

@Service
public class ChiefCommanderFactory implements AlienFactory {

    @Override
    public String getType() {
        return "ChiefCommander";
    }
    @Override
    public Alien createAlien(AlienDTO alienDTO) {
        ChiefCommander chiefCommander = new ChiefCommander();
        chiefCommander.setName(alienDTO.getName());
        if (alienDTO.getVehicle() != null && !alienDTO.getVehicle().isEmpty()) {
            chiefCommander.setVehicle(alienDTO.getVehicle());
        }
        chiefCommander.setType("ChiefCommander");
        return chiefCommander;
    }
}
