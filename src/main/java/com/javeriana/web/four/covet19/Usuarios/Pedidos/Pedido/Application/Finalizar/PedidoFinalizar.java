package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.Finalizar;

import com.javeriana.web.four.covet19.Shared.Domain.Mascota.IdMascota;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Exceptions.MascotaNotExist;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Ports.MascotaRepository;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.ValueObjects.*;

import java.util.Optional;

public class PedidoFinalizar {

    private MascotaRepository repository;

    public PedidoFinalizar(MascotaRepository repository) {
        this.repository = repository;
    }

    public void execute(
            String id,
            String tipo,
            String raza,
            String nombre,
            double peso,
            int edad
    ) {
        Optional<Mascota> mascota = repository.find(id);
        if (mascota.isEmpty())
        {
            throw new MascotaNotExist("The product " + id + " not exists");
        }
        Mascota mascotaTemp = mascota.get();
        mascotaTemp.update(new Mascota(
                new IdMascota(id),
                new EdadMascota(edad),
                new NombreMascota(nombre),
                new PesoMascota(peso),
                new TipoMascota(tipo),
                new RazaMascota(raza),
                null));
        repository.update(mascotaTemp);
    }
}
