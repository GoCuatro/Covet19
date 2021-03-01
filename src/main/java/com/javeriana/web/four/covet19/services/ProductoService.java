package com.javeriana.web.four.covet19.services;

import com.javeriana.web.four.covet19.models.Producto;

import java.util.List;

public interface ProductoService {
    public Producto addProducto(Producto producto);
    public Producto getProductoById(long id);
    public List<Producto> getAll();
}
