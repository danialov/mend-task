package com.example.mend.factory;

import com.example.mend.dtos.AlienDTO;
import com.example.mend.models.Alien;

public interface AlienFactory {
    Alien createAlien(AlienDTO alienDTO);
    String getType();
}
