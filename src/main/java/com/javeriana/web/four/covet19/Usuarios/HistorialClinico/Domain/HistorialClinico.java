package com.javeriana.web.four.covet19.Usuarios.HistorialClinico.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.HistorialClinico.IdHistorial;
import com.javeriana.web.four.covet19.Shared.Domain.Mascota.IdMascota;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.IdPersona;
import com.javeriana.web.four.covet19.Usuarios.HistorialClinico.Domain.ValueObjects.Diagnostico;
import com.javeriana.web.four.covet19.Usuarios.HistorialClinico.Domain.ValueObjects.FechaHistorial;

import java.util.HashMap;
import java.util.Objects;


public class HistorialClinico {
    private IdHistorial idHistorial;
    private Diagnostico diagnostico;
    private FechaHistorial fechaHistorial;
    private IdPersona idVeterinario;
    private IdMascota idMascota;

    public HistorialClinico(
            IdHistorial idHistorial,
            Diagnostico diagnosticoCita,
            FechaHistorial fechaHistorial,
            IdPersona idVeterinario,
            IdMascota idMascota) {
        this.idHistorial = idHistorial;
        this.diagnostico = diagnosticoCita;
        this.fechaHistorial = fechaHistorial;
        this.idVeterinario = idVeterinario;
        this.idMascota = idMascota;
    }

    public static HistorialClinico create(
            IdHistorial idHistorial,
            Diagnostico diagnosticoCita,
            FechaHistorial fechaHistorial,
            IdPersona idVeterinario,
            IdMascota idMascota) {
        return new HistorialClinico(idHistorial, diagnosticoCita, fechaHistorial, idVeterinario, idMascota);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistorialClinico historialClinico = (HistorialClinico) o;
        return Objects.equals(idHistorial, historialClinico.idHistorial) &&
                Objects.equals(diagnostico, historialClinico.diagnostico) &&
                Objects.equals(fechaHistorial, historialClinico.fechaHistorial) &&
                Objects.equals(idVeterinario, historialClinico.idVeterinario) &&
                Objects.equals(idMascota, historialClinico.idHistorial);
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", idHistorial.value());
            put("diagnostico", diagnostico.value());
            put("fechaHistorial", fechaHistorial.value());
            put("idVeterinario", idVeterinario.value());
            put("idMascota", idMascota.value());

        }};
        return data;
    }

    private HistorialClinico() {

    }

}
