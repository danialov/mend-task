package com.example.mend.factory.impl;

import com.example.mend.dtos.AlienDTO;
import com.example.mend.factory.AlienFactory;
import com.example.mend.models.Alien;
import com.example.mend.models.Warrior;
import org.springframework.stereotype.Service;

@Service
public class WarriorFactory implements AlienFactory {
    @Override
    public String getType() {
        return "Warrior";
    }

    @Override
    public Alien createAlien(AlienDTO alienDTO) {
        Warrior warrior = new Warrior();
        warrior.setName(alienDTO.getName());
        warrior.setWeapon(alienDTO.getWeapon());
        warrior.setCommanderId(alienDTO.getCommanderId());
        warrior.setType("Warrior");
        return warrior;
    }
}
