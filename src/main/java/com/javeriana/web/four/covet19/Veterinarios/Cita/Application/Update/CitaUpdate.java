package com.javeriana.web.four.covet19.Veterinarios.Cita.Application.Update;

import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Exceptions.CitaNotExist;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Ports.CitaRepository;

import java.util.Optional;

public class CitaUpdate {

    private CitaRepository repository;

    public CitaUpdate(CitaRepository repository){ this.repository = repository; }

    public void execute(
            String id,
            String diagnostico,
            String fechaCita,
            String idVeterinario,
            String idMascota
    ){
        Optional<Cita> cita = repository.find(id);
         if (cita.isEmpty()){
             throw new CitaNotExist("la cita " + id + "not exist");
         }

    }

}
