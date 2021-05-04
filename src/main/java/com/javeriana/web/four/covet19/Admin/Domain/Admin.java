package com.javeriana.web.four.covet19.Admin.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.*;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthCredentials;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthEntity;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.Exceptions.IncorrectCredentials;

import java.util.HashMap;

public class Admin implements AuthEntity {
    private IdPersona idAdmin;
    private CedulaPersona cedulaAdmin;
    private NombrePersona nombreAdmin;
    private TelefonoPersona telefonoAdmin;
    private CorreoPersona correoAdmin;
    private DireccionPersona direccionAdmin;
    private PasswordPersona passwordAdmin;
    private FechaNacimientoPersona fechaNacimientoAdmin;

    public Admin(IdPersona idAdmin, CedulaPersona cedulaAdmin, NombrePersona nombreAdmin, TelefonoPersona telefonoAdmin, CorreoPersona correoAdmin, DireccionPersona direccionAdmin, PasswordPersona passwordAdmin, FechaNacimientoPersona fechaNacimientoAdmin) {
        this.idAdmin = idAdmin;
        this.cedulaAdmin = cedulaAdmin;
        this.nombreAdmin = nombreAdmin;
        this.telefonoAdmin = telefonoAdmin;
        this.correoAdmin = correoAdmin;
        this.direccionAdmin = direccionAdmin;
        this.passwordAdmin = passwordAdmin;
        this.fechaNacimientoAdmin = fechaNacimientoAdmin;
    }

    public Admin() {
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", idAdmin.value());
            put("cedula", cedulaAdmin.value());
            put("nombre", nombreAdmin.value());
            put("telefono", telefonoAdmin.value());
            put("correo", correoAdmin.value());
            put("direccion", direccionAdmin.value());
            put("fechaNacimiento", fechaNacimientoAdmin.value());
        }};
    }

    public static Admin create(String idAdmin, long cedulaAdmin, String nombreAdmin, long telefonoAdmin, String correoAdmin, String direccionAdmin, String passwordAdmin, String fechaNacimientoAdmin) {
        return new Admin(new IdPersona(idAdmin),
                new CedulaPersona(cedulaAdmin),
                new NombrePersona(nombreAdmin),
                new TelefonoPersona(telefonoAdmin),
                new CorreoPersona(correoAdmin),
                new DireccionPersona(direccionAdmin),
                new PasswordPersona(passwordAdmin),
                new FechaNacimientoPersona(fechaNacimientoAdmin));
    }

    @Override
    public AuthCredentials getCredentials(String supposedPass) throws IncorrectCredentials {
        if (passwordAdmin.equals(new PasswordPersona(supposedPass))) {
            String authorities = "ROLE_ADMIN";
            return new AuthCredentials(idAdmin.value(), authorities, new HashMap<String, Object>());
        } else {
            throw new IncorrectCredentials("Credenciales incorrectas");
        }
    }
}
