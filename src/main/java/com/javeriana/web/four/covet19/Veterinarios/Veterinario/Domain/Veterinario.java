package com.javeriana.web.four.covet19.DDD.Veterinarios.Veterinario.Domain;

import com.javeriana.web.four.covet19.DDD.Shared.Domain.Persona.Persona;
import com.javeriana.web.four.covet19.DDD.Shared.Domain.Persona.ValueObjects.*;
import com.javeriana.web.four.covet19.DDD.Veterinarios.Veterinario.Domain.ValueObjects.TarjetaProfesional;

public class Veterinario extends Persona {
    private TarjetaProfesional tarjetaProfesional;

    public Veterinario(
            IdPersona idPersona,
            CedulaPersona cedulaPersona,
            CorreoPersona correoPersona,
            DireccionPersona direccionPersona,
            FechaNacimientoPersona fechaNacimientoPersona,
            NombrePersona nombrePersona,
            PasswordPersona passwordPersona,
            TelefonoPersona telefonoPersona,
            TarjetaProfesional tarjetaProfesional
    ) {
        super(idPersona, cedulaPersona, correoPersona, direccionPersona, fechaNacimientoPersona, nombrePersona, passwordPersona, telefonoPersona);
        this.tarjetaProfesional = tarjetaProfesional;
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
            TarjetaProfesional tarjetaProfesional
    ) {
        return new Veterinario(idPersona, cedulaPersona, correoPersona, direccionPersona, fechaNacimientoPersona, nombrePersona, passwordPersona, telefonoPersona, tarjetaProfesional);
    }

}
