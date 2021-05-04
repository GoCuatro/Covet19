package com.javeriana.web.four.covet19.Admins.Admin.Application.Find;

import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AdminFinderResponse {

    private Admin admin;

    public AdminFinderResponse(Admin admin) {
        this.admin = admin;
    }

    public HashMap response() {
        HashMap<String, String> response = admin.data();
        return response;
    }

}
