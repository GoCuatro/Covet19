package com.javeriana.web.four.covet19.DDD.Shared.Domain.Persona.ValueObjects;

import com.javeriana.web.four.covet19.DDD.Shared.Domain.StringValueObject;

public class CorreoPersona extends StringValueObject {

    private CorreoPersona() {}

    public CorreoPersona(String correo) {
        this.validate(correo);
        this.value = correo;
    }

    private void validate(String correo) {
    }

}
