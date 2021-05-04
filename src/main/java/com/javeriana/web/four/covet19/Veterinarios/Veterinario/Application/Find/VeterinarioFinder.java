package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.Find;

import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Admins.Admin.Domain.Port.AdminRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Ports.VeterinarioRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.Optional;

public class VeterinarioFinder {

    private VeterinarioRepository repository;

    public VeterinarioFinder(VeterinarioRepository repository) {
        this.repository = repository;
    }

    public Veterinario execute(String idVeterinario) {
        Optional<Veterinario> veterinario = repository.find(idVeterinario);
        if (veterinario.isEmpty())
        {
            throw new RuntimeException("El Veterinario con Id: " + idVeterinario + " no existe");
        }
        Veterinario finalVeterinario = veterinario.get();
        return finalVeterinario;
    }

}
