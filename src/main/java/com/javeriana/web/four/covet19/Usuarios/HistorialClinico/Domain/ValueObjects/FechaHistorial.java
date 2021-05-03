package com.javeriana.web.four.covet19.Usuarios.HistorialClinico.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.DateValueObject;

import java.util.Calendar;
import java.util.Date;

public class FechaHistorial extends DateValueObject {
    private FechaHistorial() {}

    public FechaHistorial(Date fecha) {
        this.validate(fecha);
        value = fecha;
    }

    private void validate(Date fecha) {
        Calendar currentCalendar = Calendar.getInstance();
        if (fecha.compareTo(currentCalendar.getTime()) > 0)
        {
            throw new RuntimeException("La fecha de la cita: " +  fecha + " es invalida");
        }
    }
}
