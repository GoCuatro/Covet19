package com.javeriana.web.four.covet19.Admins.Admin.Application.VerAdmins;

import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AdminVerAdminsResponse {

    private List<Admin> admins;

    public AdminVerAdminsResponse(List<Admin> admins) {
        this.admins = admins;
    }

    public List<HashMap> response() {
        List<HashMap> response = admins.stream().map(a -> a.data()).collect(Collectors.toList());
        return response;
    }
}
