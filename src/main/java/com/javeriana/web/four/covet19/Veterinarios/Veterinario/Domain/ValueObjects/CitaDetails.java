package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class CitaDetails {
    private String idCita;
    private String diagnostico;
    private Date fecha;
    private String idMascota;

    public CitaDetails(String idCita, String diagnostico, Date fecha, String idMascota) {
        this.idCita = idCita;
        this.diagnostico = diagnostico;
        this.fecha = fecha;
        this.idMascota = idMascota;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", idCita);
            put("diagnostico", diagnostico);
            put("fecha", fecha.toString());
            put("idMascota", idMascota);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CitaDetails that = (CitaDetails) o;
        return Objects.equals(idCita, that.idCita) && Objects.equals(diagnostico, that.diagnostico) && Objects.equals(fecha, that.fecha) && Objects.equals(idMascota, that.idMascota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCita, diagnostico, fecha, idMascota);
    }

    public String getIdCita() {
        return this.idCita;
    }

    public boolean equalsIdCita(CitaDetails productColorDetails) {
        return this.idCita.equals(productColorDetails.getIdCita());
    }

    private CitaDetails () {}
}
