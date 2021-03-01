package com.javeriana.web.four.covet19.services;

import com.javeriana.web.four.covet19.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    public Producto getById(long id);
}
