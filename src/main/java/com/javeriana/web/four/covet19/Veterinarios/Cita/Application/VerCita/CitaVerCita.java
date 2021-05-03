package com.javeriana.web.four.covet19.Veterinarios.Cita.Application.VerCita;

import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Ports.CitaRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CitaVerCita {

    private CitaRepository repository;

    public CitaVerCita(CitaRepository repository) {
        this.repository = repository;
    }

    public Cita execute(String idCita)
    {
        Optional<Cita> cita = repository.find(idCita);
        if (cita.isEmpty())
        {
            throw new RuntimeException("La Cita con Id: " + idCita + " no existe");
        }
        Cita finalCita = cita.get();

        return finalCita;
    }
}
