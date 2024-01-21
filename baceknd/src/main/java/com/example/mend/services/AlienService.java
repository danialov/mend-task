package com.example.mend.services;

import com.example.mend.dtos.AlienDTO;
import com.example.mend.factory.AlienFactory;
import com.example.mend.models.Alien;
import com.example.mend.projections.AlienProjection;
import com.example.mend.repositories.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AlienService {

    private final AlienRepository alienRepository;
    private final Map<String, AlienFactory> alienFactoryMap;

    @Autowired
    public AlienService(AlienRepository alienRepository, List<AlienFactory> factories) {
        this.alienRepository = alienRepository;
        this.alienFactoryMap = factories
                .stream()
                .collect(Collectors.toMap(AlienFactory::getType, factory -> factory));
    }

    public List<AlienDTO> getAllAliens() {
        List<AlienProjection> projections = alienRepository.findAllAliens();
        return projections
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Alien addAlien(AlienDTO alienDTO) {
        AlienFactory factory = alienFactoryMap.get(alienDTO.getType());
        if (factory == null) {
            throw new IllegalArgumentException("Unknown alien type: " + alienDTO.getType());
        }
        Alien alien = factory.createAlien(alienDTO);
        return alienRepository.save(alien);
    }

    private AlienDTO convertToDTO(AlienProjection projection) {
        String type = projection.getType();
        String vehicle = null;
        String weapon = null;
        Long commanderId = null;
        String commanderName = null;

        if ("Commander".equals(type) || "ChiefCommander".equals(type)) {
            vehicle = projection.getVehicle();
            if ("Commander".equals(type)) {
                commanderId = projection.getCommanderId();
            }
            commanderName = projection.getCommanderName();
        }
        if ("Warrior".equals(type)) {
            weapon = projection.getWeapon();
            commanderId = projection.getCommanderId();
            commanderName = projection.getCommanderName();
        }

        return new AlienDTO(
                type,
                projection.getId(),
                projection.getName(),
                vehicle,
                weapon,
                commanderId,
                commanderName
        );
    }

}
