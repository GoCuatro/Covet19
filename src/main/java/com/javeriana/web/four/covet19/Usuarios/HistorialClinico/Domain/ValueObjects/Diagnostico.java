package com.javeriana.web.four.covet19.Usuarios.HistorialClinico.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.StringValueObject;

public class Diagnostico extends StringValueObject {
    private Diagnostico() {}

    public Diagnostico(String diagnostico) {
        this.validate(diagnostico);
        this.value = diagnostico;
    }

    private void validate(String Diagnostico) {
    }
}
