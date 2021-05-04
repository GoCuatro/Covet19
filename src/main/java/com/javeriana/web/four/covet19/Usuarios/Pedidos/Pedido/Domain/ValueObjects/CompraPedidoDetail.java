package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class CompraPedidoDetail {
    private String id;
    private String nombre;
    private String descripcion;
    private String precio;
    private String marca;

    public CompraPedidoDetail(String id, String nombre, String descripcion, String precio, String marca) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", id);
            put("nombre", nombre);
            put("descripcion", descripcion);
            put("precio", precio);
            put("marca", marca);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraPedidoDetail that = (CompraPedidoDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(descripcion, that.descripcion) && Objects.equals(precio, that.precio )  && Objects.equals(marca, that.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, precio, marca);
    }

    public String getId() {
        return this.id;
    }

    private CompraPedidoDetail () {}

}
