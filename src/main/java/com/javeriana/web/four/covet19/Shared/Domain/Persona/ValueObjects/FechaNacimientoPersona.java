package com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class FechaNacimientoPersona {

    private Date value;

    public FechaNacimientoPersona(Date fecha) {
        this.validate(fecha);
        value = fecha;
    }

    private void validate(Date fecha) {
        Calendar currentCalendar = Calendar.getInstance();
        if (fecha.compareTo(currentCalendar.getTime()) > 0)
        {
            throw new RuntimeException("La fecha de nacimiento: " +  fecha + " es invalida");
        }
    }

    public Date value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaNacimientoPersona that = (FechaNacimientoPersona) o;
        return Objects.equals(value, that.value);
    }
}
