package com.javeriana.web.four.covet19.services;

import com.javeriana.web.four.covet19.models.Cita;

import java.util.List;

public interface VeterinarioService {
    List<Cita> getAgenda(String id);
}
