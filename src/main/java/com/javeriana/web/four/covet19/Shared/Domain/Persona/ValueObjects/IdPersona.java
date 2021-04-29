package com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.CustomUUID;

public class IdPersona extends CustomUUID
{
    private IdPersona() {
        super("");
    }

    public IdPersona(String value) {
        super(value);
    }
}