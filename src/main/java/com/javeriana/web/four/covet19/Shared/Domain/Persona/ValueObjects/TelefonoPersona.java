package com.javeriana.web.four.covet19.DDD.Shared.Domain.Persona.ValueObjects;

import java.util.Objects;

public class TelefonoPersona {

    private long value;

    public TelefonoPersona(long telefono) {
        this.validate(telefono);
        value = telefono;
    }

    private void validate(long telefono) {
        if (telefono < 0)
        {
            throw new RuntimeException("El teléfono: " +  telefono + " no puede ser negativo");
        }
    }

    public long value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefonoPersona that = (TelefonoPersona) o;
        return Objects.equals(value, that.value);
    }

}
