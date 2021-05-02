package com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.DateValueObject;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class FechaNacimientoPersona extends DateValueObject {

    private FechaNacimientoPersona() {}

    public FechaNacimientoPersona(Date fecha) {
        this.validate(fecha);
        this.value = fecha;
    }

    private void validate(Date fecha) {
        Calendar currentCalendar = Calendar.getInstance();
        if (fecha.compareTo(currentCalendar.getTime()) > 0)
        {
            throw new RuntimeException("La fecha de nacimiento: " +  fecha + " es invalida");
        }
    }

}
