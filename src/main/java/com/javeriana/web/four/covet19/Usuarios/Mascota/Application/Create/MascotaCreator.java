package com.javeriana.web.four.covet19.Usuarios.Mascota.Application.Create;

import com.javeriana.web.four.covet19.Shared.Domain.Mascota.IdMascota;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.ValueObjects.*;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Infrastructure.Hibernate.HibernateMascotaRepository;

public class MascotaCreator {

    private HibernateMascotaRepository repository;

    public MascotaCreator(HibernateMascotaRepository repository) {
        this.repository = repository;
    }

    public MascotaCreator() {
    }

    public void execute(String idMascota,
                        String nombreMascota,
                        int edadMascota,
                        double pesoMascota,
                        String tipoMascota,
                        String razaMascota) {
        Mascota mascota = Mascota.create(
                new IdMascota(idMascota),
                new EdadMascota(edadMascota),
                new NombreMascota(nombreMascota),
                new PesoMascota(pesoMascota),
                new TipoMascota(tipoMascota),
                new RazaMascota(razaMascota)
        );
        repository.save(mascota);
    }
}
