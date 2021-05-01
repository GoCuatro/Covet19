package com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.DoubleValueObject;

public class PesoMascota extends DoubleValueObject {
    private PesoMascota() {}

    public PesoMascota(Double peso) {
        this.validate(peso);
        this.value = peso;
    }

    private void validate(Double peso) {
        if (peso < 0)
        {
            throw new RuntimeException("El peso: " +  peso + " no puede ser negativo");
        }
    }
}
