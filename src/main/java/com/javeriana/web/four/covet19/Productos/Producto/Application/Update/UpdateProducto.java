package com.javeriana.web.four.covet19.Productos.Producto.Application.Update;

import com.javeriana.web.four.covet19.Productos.Producto.Application.Exceptions.NotFound;
import com.javeriana.web.four.covet19.Productos.Producto.Application.Find.FindProducto;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;
import com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Hibernate.HibernateProductoRepository;

import java.util.Optional;

public class UpdateProducto {
    private HibernateProductoRepository repository;

    public UpdateProducto(HibernateProductoRepository repository) {
        this.repository = repository;
    }

    public void execute(UpdateRequest updateRequest){
        if(updateRequest.getId().isEmpty()){
            throw new NotFound("Falta el id del producto");
        }
        Optional<Producto> producto = new FindProducto(repository).execute(updateRequest.getId().get());
        if(producto.isEmpty()){
            throw new NotFound("Producto no encontrado");
        }
        if(updateRequest.getNombre().isPresent()){
            producto.get().updateNombreProducto(updateRequest.getNombre().get());
        }
        if(updateRequest.getDescripcion().isPresent()){
            producto.get().updateDescripcionProducto(updateRequest.getDescripcion().get());
        }
        if(updateRequest.getPrecio().isPresent()){
            producto.get().updatePrecioProducto(updateRequest.getPrecio().get());
        }
        if(updateRequest.getMarca().isPresent()){
            producto.get().updateMarcaProducto(updateRequest.getMarca().get());
        }
        repository.update(producto.get());
    }
}
