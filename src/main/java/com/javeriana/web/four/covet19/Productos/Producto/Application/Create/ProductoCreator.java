package com.javeriana.web.four.covet19.Productos.Producto.Application.Create;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Ports.ProductoRepository;

public class ProductoCreator {
    private ProductoRepository repository;

    public ProductoCreator(ProductoRepository repository) {
        this.repository = repository;
    }

    public void execute(String nombre, String descripcion, String marca ){

    }
}
