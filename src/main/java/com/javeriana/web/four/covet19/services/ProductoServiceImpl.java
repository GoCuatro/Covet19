package com.javeriana.web.four.covet19.services;

import com.javeriana.web.four.covet19.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    private ProductoRepository repository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Producto addProducto(Producto producto) {
        try {
            producto = this.repository.save(producto);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return producto;
    }

    @Override
    public Producto getProductoById(long id) {
        Producto respuesta = null;
        try {
            respuesta = this.repository.getById(id);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return respuesta;
    }

    @Override
    public List<Producto> getAll() {
        return this.repository.findAll();
    }
}
