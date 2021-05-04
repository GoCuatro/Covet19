package com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;

import java.util.HashMap;
import java.util.Objects;

public class CarritoUsuario {
    private long cantidad;
    private String idProducto;

    public CarritoUsuario(long cantidad, String idProducto) {
        this.cantidad = cantidad;
        this.idProducto = idProducto;
    }

    public HashMap<String, Object> data()
    {
        HashMap<String, Object> data = new HashMap<String, Object>(){{
            put("idProducto",idProducto);
            put("cantidad", cantidad);
        }};
        return data;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarritoUsuario that = (CarritoUsuario) o;
        return Objects.equals(idProducto, that.idProducto);
    }
    private CarritoUsuario(){};
}
