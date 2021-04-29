package com.javeriana.web.four.covet19.DDD.Veterinarios.Veterinario.Domain.ValueObjects;

import com.javeriana.web.four.covet19.DDD.Shared.Domain.StringValueObject;

public class TarjetaProfesional extends StringValueObject {

    private TarjetaProfesional() {}

    public TarjetaProfesional(String tarjeta) {
        this.validate(tarjeta);
        this.value = tarjeta;
    }

    private void validate(String tarjeta) {
    }

}
