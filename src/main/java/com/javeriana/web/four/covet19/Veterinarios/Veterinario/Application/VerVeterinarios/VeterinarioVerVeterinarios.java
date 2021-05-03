package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.VerVeterinarios;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Ports.VeterinarioRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeterinarioVerVeterinarios {
    private VeterinarioRepository repository;

    public VeterinarioVerVeterinarios(VeterinarioRepository repository) {
        this.repository = repository;
    }

    public List<Veterinario> execute()
    {
        Optional<List<Veterinario>> veterinarios = repository.all();
        if (veterinarios.isEmpty())
        {
            throw new RuntimeException("No hay veterinarios");
        }
        List<Veterinario> result = veterinarios.get();
        return result;
    }

}
