package com.example.mend.controllers;

import com.example.mend.dtos.AlienDTO;
import com.example.mend.models.Alien;
import com.example.mend.services.AlienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aliens")
public class AlienController {

    private final AlienService alienService;

    @Autowired
    public AlienController(AlienService alienService) {
        this.alienService = alienService;
    }

    @GetMapping("")
    public ResponseEntity<List<AlienDTO>> getAllAliens() {
        List<AlienDTO> aliens = alienService.getAllAliens();
        return new ResponseEntity<>(aliens, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Alien> addAlien(@Valid @RequestBody AlienDTO alienDTO) {
        Alien savedAlien = alienService.addAlien(alienDTO);
        return new ResponseEntity<>(savedAlien, HttpStatus.CREATED);
    }
}
