package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.Create;

import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.*;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Ports.VeterinarioRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.TarjetaProfesionalVeterinario;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.Date;
import java.util.List;

public class VeterinarioCreator {

    VeterinarioRepository repository;

    public VeterinarioCreator(VeterinarioRepository repository) {
        this.repository = repository;
    }

    public void execute(String idVeterinario,
                        long cedulaVeterinario,
                        String correoVeterinario,
                        String direccionVeterinario,
                        Date fechaNacimientoVeterinario,
                        String nombreVeterinario,
                        String passwordVeterinario,
                        long telefonoVeterinario,
                        String tarjetaProfesionalVeterinario
    ) {
        Veterinario veterinario = Veterinario.create(
                new IdPersona(idVeterinario),
                new CedulaPersona(cedulaVeterinario),
                new CorreoPersona(correoVeterinario),
                new DireccionPersona(direccionVeterinario),
                new FechaNacimientoPersona(fechaNacimientoVeterinario),
                new NombrePersona(nombreVeterinario),
                new PasswordPersona(passwordVeterinario),
                new TelefonoPersona(telefonoVeterinario),
                new TarjetaProfesionalVeterinario(tarjetaProfesionalVeterinario));

        repository.save(veterinario);

    }

}
