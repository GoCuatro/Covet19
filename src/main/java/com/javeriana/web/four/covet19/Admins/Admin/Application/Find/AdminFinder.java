package com.javeriana.web.four.covet19.Admins.Admin.Application.Find;

import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Admins.Admin.Domain.Port.AdminRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdminFinder {
    private AdminRepository repository;

    public AdminFinder(AdminRepository repository) {
        this.repository = repository;
    }

    public Admin execute(String idAdmin) {
        Optional<Admin> admin = repository.find(idAdmin);
        if (admin.isEmpty())
        {
            throw new RuntimeException("El Admin con Id: " + idAdmin + " no existe");
        }
        Admin finalAdmin = admin.get();
        return finalAdmin;
    }

}
