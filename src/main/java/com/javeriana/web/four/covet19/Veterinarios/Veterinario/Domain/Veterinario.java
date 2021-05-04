package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.*;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.TarjetaProfesionalVeterinario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Veterinario {

    private IdPersona idVeterinario;
    private CedulaPersona cedulaVeterinario;
    private CorreoPersona correoVeterinario;
    private DireccionPersona direccionVeterinario;
    private FechaNacimientoPersona fechaNacimientoVeterinario;
    private NombrePersona nombreVeterinario;
    private PasswordPersona passwordVeterinario;
    private TelefonoPersona telefonoVeterinario;
    private TarjetaProfesionalVeterinario tarjetaProfesionalVeterinario;
    private Optional<List<CitaDetails>> agendaVeterinario;

    public Veterinario(
            IdPersona idVeterinario,
            CedulaPersona cedulaVeterinario,
            CorreoPersona correoVeterinario,
            DireccionPersona direccionVeterinario,
            FechaNacimientoPersona fechaNacimientoVeterinario,
            NombrePersona nombreVeterinario,
            PasswordPersona passwordVeterinario,
            TelefonoPersona telefonoVeterinario,
            TarjetaProfesionalVeterinario tarjetaProfesionalVeterinario,
            List<CitaDetails> agendaVeterinario
    ) {
        this.idVeterinario = idVeterinario;
        this.cedulaVeterinario = cedulaVeterinario;
        this.correoVeterinario = correoVeterinario;
        this.direccionVeterinario = direccionVeterinario;
        this.fechaNacimientoVeterinario = fechaNacimientoVeterinario;
        this.nombreVeterinario = nombreVeterinario;
        this.passwordVeterinario = passwordVeterinario;
        this.telefonoVeterinario = telefonoVeterinario;
        this.tarjetaProfesionalVeterinario = tarjetaProfesionalVeterinario;
        this.agendaVeterinario = Optional.ofNullable(agendaVeterinario);
    }

    public static Veterinario create(
            IdPersona idPersona,
            CedulaPersona cedulaPersona,
            CorreoPersona correoPersona,
            DireccionPersona direccionPersona,
            FechaNacimientoPersona fechaNacimientoPersona,
            NombrePersona nombrePersona,
            PasswordPersona passwordPersona,
            TelefonoPersona telefonoPersona,
            TarjetaProfesionalVeterinario tarjetaProfesionalVeterinario
    ) {
        return new Veterinario(idPersona, cedulaPersona, correoPersona, direccionPersona, fechaNacimientoPersona, nombrePersona, passwordPersona, telefonoPersona, tarjetaProfesionalVeterinario, null);
    }

    public void update(
            CedulaPersona cedulaPersona,
            CorreoPersona correoPersona,
            DireccionPersona direccionPersona,
            FechaNacimientoPersona fechaNacimientoPersona,
            NombrePersona nombrePersona,
            PasswordPersona passwordPersona,
            TelefonoPersona telefonoPersona,
            TarjetaProfesionalVeterinario tarjetaProfesionalVeterinario
    ) {
        this.cedulaVeterinario = cedulaPersona;
        this.correoVeterinario = correoPersona;
        this.direccionVeterinario = direccionPersona;
        this.fechaNacimientoVeterinario = fechaNacimientoPersona;
        this.nombreVeterinario = nombrePersona;
        this.passwordVeterinario = passwordPersona;
        this.telefonoVeterinario = telefonoPersona;
        this.tarjetaProfesionalVeterinario = tarjetaProfesionalVeterinario;
    }

    public Optional<List<HashMap<String, Object>>> getAgendaVeterinario() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.agendaVeterinario.isPresent()) {
            response = Optional.of(this.agendaVeterinario.get().stream().map(cita -> cita.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public void addCitaDetails(CitaDetails citaDetails) {
        List<CitaDetails> productColorDetailsList =
                this.agendaVeterinario.isEmpty() ? new ArrayList<>() : this.agendaVeterinario.get();
        productColorDetailsList.add(citaDetails);
        this.agendaVeterinario = Optional.ofNullable(productColorDetailsList);
    }

    public void updateCitaDetails(CitaDetails citaDetails) {
        List<CitaDetails> citasDetailsList = this.agendaVeterinario.get();
        CitaDetails citaDetailsActual = citasDetailsList.stream().
                filter(cita -> cita.equalsIdCita(citaDetails)).findFirst().get();
        citasDetailsList.remove(citaDetailsActual);
        citasDetailsList.add(citaDetails);
        this.agendaVeterinario = Optional.ofNullable(citasDetailsList);
    }

    public void updateCitaDiagnostico(String idCita, String diagnostico) {
        List<CitaDetails> citasDetailsList = this.agendaVeterinario.get();
        CitaDetails citaDetailsActual = citasDetailsList.stream().
                filter(cita -> cita.equalsIdCita(idCita)).findFirst().get();
        citaDetailsActual.updateDiagnostico(diagnostico);
        this.agendaVeterinario = Optional.ofNullable(citasDetailsList);
    }

    public Optional<List<CitaDetails>> getAgenda() {
        return agendaVeterinario;
    }

    public HashMap<String, Object> data() {
        return new HashMap<String, Object>() {{
            put("id", idVeterinario.value());
            put("cedula", cedulaVeterinario.value());
            put("correo", correoVeterinario.value());
            put("direccion", direccionVeterinario.value());
            put("fechaNacimiento", fechaNacimientoVeterinario.value().toString());
            put("nombre", nombreVeterinario.value());
            put("password", passwordVeterinario.value());
            put("telefono", telefonoVeterinario.value());
            put("tarjetaProfesional", tarjetaProfesionalVeterinario.value());
            put("agenda", getAgendaVeterinario());
        }};
    }

    private Veterinario() {}

}
