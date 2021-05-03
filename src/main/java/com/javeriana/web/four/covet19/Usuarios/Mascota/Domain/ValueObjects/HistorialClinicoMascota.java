package com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.ValueObjects;



import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class HistorialClinicoMascota {
    private String idHistorial;
    private String diagnostico;
    private Date fecha;
    private String idVeterinario;

    public HistorialClinicoMascota(String idHistorial, String diagnostico, Date fecha, String idPersona) {
        this.idHistorial = idHistorial;
        this.diagnostico = diagnostico;
        this.fecha = fecha;
        this.idVeterinario = idPersona;
    }
    public HistorialClinicoMascota(){}

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", idHistorial);
            put("diagnostico", diagnostico);
            put("fecha", fecha);
            put("idVeterinario", idVeterinario);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistorialClinicoMascota that = (HistorialClinicoMascota) o;
        return Objects.equals(idHistorial, that.idHistorial) && Objects.equals(diagnostico, that.diagnostico) && Objects.equals(fecha, that.fecha) && Objects.equals(idVeterinario, that.idVeterinario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHistorial, diagnostico, fecha, idVeterinario);
    }

    public String getIdHistorial() {
        return this.idHistorial;
    }

    public boolean equalsIdHistorial(HistorialClinicoMascota historialClinicoMascota) {
        return this.idHistorial.equals(historialClinicoMascota.getIdHistorial());
    }
}
