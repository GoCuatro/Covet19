package com.javeriana.web.four.covet19.Productos.Producto.Domain;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.ValueObjects.*;
import com.javeriana.web.four.covet19.Shared.Domain.Productos.ProductoId;

import java.util.HashMap;
import java.util.Objects;

public class Producto {
    private ProductoId productoId;
    private NombreProducto nombreProducto;
    private DescripcionProducto descripcionProducto;
    private PrecioProducto precioProducto;
    private MarcaProducto marcaProducto;
    private InventarioProducto inventarioProducto;
    private HabilitadoProducto habilitadoProducto;

    public Producto(ProductoId productoId, NombreProducto nombreProducto, DescripcionProducto descripcionProducto, PrecioProducto precioProducto, MarcaProducto marcaProducto, InventarioProducto inventarioProducto, HabilitadoProducto habilitadoProducto) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.marcaProducto = marcaProducto;
        this.inventarioProducto = inventarioProducto;
        this.habilitadoProducto = habilitadoProducto;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", productoId.value());
            put("nombre", nombreProducto.value());
            put("descripcion", descripcionProducto.value());
            put("precio", precioProducto.value());
            put("marca", marcaProducto.value());
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto product = (Producto) o;
        return Objects.equals(productoId, product.productoId) &&
                Objects.equals(nombreProducto, product.nombreProducto) &&
                Objects.equals(descripcionProducto, product.descripcionProducto) &&
                Objects.equals(marcaProducto, product.marcaProducto);
    }
}
