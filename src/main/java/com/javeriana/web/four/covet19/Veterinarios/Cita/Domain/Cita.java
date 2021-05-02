package com.javeriana.web.four.covet19.Veterinarios.Cita.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Citas.IdCita;
import com.javeriana.web.four.covet19.Shared.Domain.Mascota.IdMascota;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.IdPersona;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.ValueObjects.DiagnosticoCita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.ValueObjects.FechaCita;

public class Cita {
    private IdCita idCita;
    private DiagnosticoCita diagnosticoCita;
    private FechaCita fechaCita;
    private IdPersona idVeterinario;
    private IdMascota idMascota;

    public Cita(IdCita idCita, DiagnosticoCita diagnosticoCita, FechaCita fechaCita, IdPersona idVeterinario, IdMascota idMascota) {
        this.idCita = idCita;
        this.diagnosticoCita = diagnosticoCita;
        this.fechaCita = fechaCita;
        this.idVeterinario = idVeterinario;
        this.idMascota = idMascota;
    }

    public static Cita create(IdCita idCita, DiagnosticoCita diagnosticoCita, FechaCita fechaCita, IdPersona idVeterinario, IdMascota idMascota) {
        return new Cita(idCita, diagnosticoCita, fechaCita, idVeterinario, idMascota);
    }

    public void agregarDiagnostico(DiagnosticoCita diagnosticoCita) {
        this.diagnosticoCita = diagnosticoCita;
    }
}
