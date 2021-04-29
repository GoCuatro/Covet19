package com.javeriana.web.four.covet19.DDD.Shared.Domain.Persona.ValueObjects;

import java.util.Objects;

public class CedulaPersona {

    private long value;

    public CedulaPersona(long cedula) {
        this.validate(cedula);
        value = cedula;
    }

    private void validate(long cedula) {
        if (cedula < 0)
        {
            throw new RuntimeException("La cédula: " +  cedula + " no puede ser negativa");
        }
    }

    public long value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CedulaPersona that = (CedulaPersona) o;
        return Objects.equals(value, that.value);
    }

}
