package com.javeriana.web.four.covet19.Usuarios.Mascota.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Mascota.IdMascota;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.ValueObjects.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


public class Mascota {
    private IdMascota idMascota;
    private EdadMascota edadMascota;
    private NombreMascota nombreMascota;
    private PesoMascota pesoMascota;
    private TipoMascota tipoMascota;
    private RazaMascota razaMascota;
    private Optional<List<CitaHistorialMascota>> historialClinicoMascota;

    public Mascota(
            IdMascota idMascota,
            EdadMascota edadMascota,
            NombreMascota nombreMascota,
            PesoMascota pesoMascota,
            TipoMascota tipoMascota,
            RazaMascota razaMascota,
            List<CitaHistorialMascota> citaHistorialMascota) {
        this.idMascota = idMascota;
        this.edadMascota = edadMascota;
        this.nombreMascota = nombreMascota;
        this.pesoMascota = pesoMascota;
        this.tipoMascota = tipoMascota;
        this.razaMascota = razaMascota;
        this.historialClinicoMascota = Optional.ofNullable(citaHistorialMascota);
    }
    public static Mascota create(
            IdMascota idMascota,
            EdadMascota edadMascota,
            NombreMascota nombreMascota,
            PesoMascota pesoMascota,
            TipoMascota tipoMascota,
            RazaMascota razaMascota) {
        return new Mascota(idMascota,edadMascota, nombreMascota, pesoMascota,tipoMascota, razaMascota, null);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mascota mascota = (Mascota) o;
        return Objects.equals(idMascota, mascota.idMascota) &&
                Objects.equals(nombreMascota, mascota.nombreMascota) &&
                Objects.equals(edadMascota, mascota.edadMascota) &&
                Objects.equals(tipoMascota, mascota.tipoMascota) &&
                Objects.equals(razaMascota, mascota.razaMascota) &&
                Objects.equals(historialClinicoMascota, mascota.historialClinicoMascota);
    }

    public HashMap<String, Object> data()
    {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", idMascota.value());
            put("nombre", nombreMascota.value());
            put("peso", pesoMascota.value());
            put("raza", razaMascota.value());
            put("edad", edadMascota.value());
            put("tipo", tipoMascota.value());
            put("historialClinico", getHistorialClinico());

        }};
        return data;
    }

    public Optional<List<HashMap<String, Object>>> getHistorialClinico() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.historialClinicoMascota.isPresent()) {
            response = Optional.of(this.historialClinicoMascota.get().stream().map(cita -> cita.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public void update(Mascota mascota){
        this.idMascota = mascota.idMascota;
        this.edadMascota = mascota.edadMascota;
        this.nombreMascota = mascota.nombreMascota;
        this.pesoMascota = mascota.pesoMascota;
        this.tipoMascota = mascota.tipoMascota;
        this.razaMascota = mascota.razaMascota;
    }

    private Mascota(){
    }

    public void updateCitaDiagnostico(String idCita, String diagnostico) {
        List<CitaHistorialMascota> citasDetailsList = this.historialClinicoMascota.get();
        CitaHistorialMascota historialActual = citasDetailsList.stream().
                filter(cita -> cita.equalsIdCita(idCita)).findFirst().get();
        historialActual.updateDiagnostico(diagnostico);
        this.historialClinicoMascota = Optional.ofNullable(citasDetailsList);
    }
    public void updateCitaFecha(String idCita, String fecha) {
        List<CitaHistorialMascota> citasDetailsList = this.historialClinicoMascota.get();
        CitaHistorialMascota historialActual = citasDetailsList.stream().
                filter(cita -> cita.equalsIdCita(idCita)).findFirst().get();
        historialActual.updateFecha(fecha);
        this.historialClinicoMascota = Optional.ofNullable(citasDetailsList);
    }
    public void agregarCita(String idCita, String diagnostico, String fecha, String idVeterinario) {
        List<CitaHistorialMascota> citasDetailsList = this.historialClinicoMascota.get();
        CitaHistorialMascota citaNueva = new CitaHistorialMascota(idCita, diagnostico, fecha, idVeterinario);
        citasDetailsList.add(citaNueva);
        this.historialClinicoMascota = Optional.ofNullable(citasDetailsList);
    }

    public NombreMascota getNombreMascota() {
        return nombreMascota;
    }



}
