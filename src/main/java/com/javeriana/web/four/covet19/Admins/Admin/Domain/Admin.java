package com.javeriana.web.four.covet19.Admins.Admin.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.*;

import java.util.HashMap;

public class Admin {
    private IdPersona idAdmin;
    private CedulaPersona cedulaAdmin;
    private CorreoPersona correoAdmin;
    private DireccionPersona direccionAdmin;
    private FechaNacimientoPersona fechaNacimientoAdmin;
    private NombrePersona nombreAdmin;
    private PasswordPersona passwordAdmin;
    private TelefonoPersona telefonoAdmin;

    public Admin(
            IdPersona idAdmin,
            CedulaPersona cedulaAdmin,
            CorreoPersona correoAdmin,
            DireccionPersona direccionAdmin,
            FechaNacimientoPersona fechaNacimientoAdmin,
            NombrePersona nombreAdmin,
            PasswordPersona passwordAdmin,
            TelefonoPersona telefonoAdmin
    ) {
        this.idAdmin = idAdmin;
        this.cedulaAdmin = cedulaAdmin;
        this.correoAdmin = correoAdmin;
        this.direccionAdmin = direccionAdmin;
        this.fechaNacimientoAdmin = fechaNacimientoAdmin;
        this.nombreAdmin = nombreAdmin;
        this.passwordAdmin = passwordAdmin;
        this.telefonoAdmin = telefonoAdmin;
    }

    public static Admin create(
            IdPersona idPersona,
            CedulaPersona cedulaPersona,
            CorreoPersona correoPersona,
            DireccionPersona direccionPersona,
            FechaNacimientoPersona fechaNacimientoPersona,
            NombrePersona nombrePersona,
            PasswordPersona passwordPersona,
            TelefonoPersona telefonoPersona
    ) {
        return new Admin(idPersona, cedulaPersona, correoPersona, direccionPersona, fechaNacimientoPersona, nombrePersona, passwordPersona, telefonoPersona);
    }

    public HashMap<String, String> data() {
        return new HashMap<String, String>() {{
            put("id", idAdmin.value());
            put("cedula", cedulaAdmin.value().toString());
            put("correo", correoAdmin.value());
            put("direccion", direccionAdmin.value());
            put("fecha", fechaNacimientoAdmin.value().toString());
            put("nombre", nombreAdmin.value());
            put("password", passwordAdmin.value());
            put("telefono", telefonoAdmin.value().toString());
        }};
    }

    private Admin() {}

}
