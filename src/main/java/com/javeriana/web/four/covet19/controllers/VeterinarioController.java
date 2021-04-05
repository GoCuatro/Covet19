package com.javeriana.web.four.covet19.controllers;

import com.javeriana.web.four.covet19.models.Cita;
import com.javeriana.web.four.covet19.services.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VeterinarioController {
    private VeterinarioService service;

    @Autowired
    public VeterinarioController(VeterinarioService service) {
        this.service = service;
    }

    @GetMapping(value = "/vet/agenda", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cita>> getAgenda(){
        return new ResponseEntity<>(service.getAgenda("hola"), HttpStatus.OK);
    }
}
