package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Ports;

import com.javeriana.web.four.covet19.Shared.Domain.Persona.Persona;

import java.util.List;
import java.util.Optional;

public interface VeterinarioRepository {
    void update(Persona persona);
    Optional<Persona> find (String ProductId);
    void save(Persona persona);
    Optional<List<Persona>> all();
}
