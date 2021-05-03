package com.javeriana.web.four.covet19.Veterinarios.Cita.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Citas.IdCita;
import com.javeriana.web.four.covet19.Shared.Domain.Mascota.IdMascota;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.IdPersona;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.ValueObjects.DiagnosticoCita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.ValueObjects.FechaCita;

import java.util.HashMap;

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

    public HashMap<String, String> data() {
        HashMap<String, String> data = new HashMap<>(){{
            put("id", idCita.value());
            put("diagnostico", diagnosticoCita.value());
            put("fecha", fechaCita.value().toString());
            put("idVeterinario", idVeterinario.value());
            put("idMascota", idMascota.value());
        }};
        return data;
    }

    public void agregarDiagnostico(DiagnosticoCita diagnosticoCita) {
        this.diagnosticoCita = diagnosticoCita;
    }

    private Cita() {}

    public String getIdVeterinario() {
        return idVeterinario.value();
    }

    public String getIdMascota() {
        return idMascota.value();
    }
}
