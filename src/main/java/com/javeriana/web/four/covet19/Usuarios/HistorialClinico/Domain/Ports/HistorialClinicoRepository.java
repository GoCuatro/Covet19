package com.javeriana.web.four.covet19.Usuarios.HistorialClinico.Domain.Ports;

import com.javeriana.web.four.covet19.Usuarios.HistorialClinico.Domain.HistorialClinico;

import java.util.List;
import java.util.Optional;

public interface HistorialClinicoRepository {
    void update(HistorialClinico historialClinico);
    Optional<HistorialClinico> find (String idHistorial);
    void save(HistorialClinico historialClinico);
    Optional<List<HistorialClinico>> all();
}
