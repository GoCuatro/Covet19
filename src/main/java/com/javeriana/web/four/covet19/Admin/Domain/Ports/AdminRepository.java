package com.javeriana.web.four.covet19.Admin.Domain.Ports;

import com.javeriana.web.four.covet19.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;

import java.util.List;
import java.util.Optional;

public interface AdminRepository {
    void update(Admin admin);

    Optional<Admin> find(String adminId);

    void save(Admin admin);

    Optional<List<Admin>> all();
}
