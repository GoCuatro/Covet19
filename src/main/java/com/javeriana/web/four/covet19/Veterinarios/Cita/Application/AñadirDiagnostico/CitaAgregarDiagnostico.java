package com.javeriana.web.four.covet19.Veterinarios.Cita.Application.AñadirDiagnostico;

import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Ports.CitaRepository;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.ValueObjects.DiagnosticoCita;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CitaAgregarDiagnostico {

    private CitaRepository repository;

    public CitaAgregarDiagnostico(CitaRepository repository) {
        this.repository = repository;
    }

    public void execute(String idCita, String diagnostico)
    {
        Optional<Cita> cita = repository.find(idCita);
        if (cita.isEmpty())
        {
            throw new RuntimeException("La cita con Id: " + idCita + " no existe");
        }
        Cita finalCita = cita.get();
        finalCita.agregarDiagnostico(new DiagnosticoCita(diagnostico));
        repository.update(finalCita);
    }

}
