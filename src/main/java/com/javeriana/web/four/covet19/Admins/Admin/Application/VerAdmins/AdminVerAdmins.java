package com.javeriana.web.four.covet19.Admins.Admin.Application.VerAdmins;

import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Admins.Admin.Domain.Port.AdminRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Ports.VeterinarioRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdminVerAdmins {

    private AdminRepository repository;

    public AdminVerAdmins(AdminRepository repository) {
        this.repository = repository;
    }

    public List<Admin> execute()
    {
        List<Admin> result = new ArrayList<>();
        Optional<List<Admin>> admins = repository.all();
        if (!admins.isEmpty())
        {
            result = admins.get();
        }
        return result;
    }

}
