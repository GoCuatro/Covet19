package com.javeriana.web.four.covet19.Veterinarios.Cita.Application.AñadirDiagnostico;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.ModificarCitaDiagnostico.MascotaModificarCitaDiagnostico;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Exceptions.CitaNoExiste;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Ports.CitaRepository;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.ValueObjects.DiagnosticoCita;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.ModificarCitaDiagnostico.VeterinarioModificarCitaDiagnostico;

import java.util.Optional;

public class CitaAgregarDiagnostico {

    private final CitaRepository repository;
    private final VeterinarioModificarCitaDiagnostico modificarCitaVeterinario;
    private final MascotaModificarCitaDiagnostico modificarCitaMascota;

    public CitaAgregarDiagnostico(CitaRepository repository,
                                  VeterinarioModificarCitaDiagnostico modificarCitaVeterinario,
                                  MascotaModificarCitaDiagnostico modificarCitaMascota
    ) {
        this.repository = repository;
        this.modificarCitaVeterinario = modificarCitaVeterinario;
        this.modificarCitaMascota = modificarCitaMascota;
    }

    public void execute(String idCita, String diagnostico)
    {
        Optional<Cita> cita = repository.find(idCita);
        if (cita.isEmpty())
        {
            throw new CitaNoExiste(idCita);
        }
        Cita finalCita = cita.get();
        finalCita.agregarDiagnostico(new DiagnosticoCita(diagnostico));

        //Evento para actualizar Citas del Veterinario
        modificarCitaVeterinario.execute(finalCita.getIdVeterinario(), idCita, diagnostico);

        //Evento para actualizar Citas de la mascota
        modificarCitaMascota.execute(finalCita.getIdMascota(), idCita, diagnostico);

        repository.update(finalCita);
    }

}
