package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.DateValueObject;

import java.util.Calendar;
import java.util.Date;

public class FechaFinalizadoPedido extends DateValueObject {

    private FechaFinalizadoPedido() {
    }

    public FechaFinalizadoPedido(Date fecha) {
        this.validate(fecha);
        value = fecha;
    }

    private void validate(Date fecha) {
        Calendar currentCalendar = Calendar.getInstance();
        if (fecha.compareTo(currentCalendar.getTime()) > 0) {
            throw new RuntimeException("La fecha de finalización: " + fecha + " es invalida");
        }
    }
}