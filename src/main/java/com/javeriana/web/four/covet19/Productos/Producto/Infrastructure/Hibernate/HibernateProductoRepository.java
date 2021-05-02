package com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Hibernate;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Ports.ProductoRepository;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class HibernateProductoRepository implements ProductoRepository {
    @Override
    public void update(Producto producto) {

    }

    @Override
    public Optional<Producto> find(String productoId) {
        return Optional.empty();
    }

    @Override
    public void save(Producto producto) {

    }

    @Override
    public Optional<List<Producto>> all() {
        return Optional.empty();
    }
}
