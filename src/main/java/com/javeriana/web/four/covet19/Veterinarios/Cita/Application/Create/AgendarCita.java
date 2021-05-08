package com.javeriana.web.four.covet19.Veterinarios.Cita.Application.Create;

import com.javeriana.web.four.covet19.Shared.Domain.Citas.IdCita;
import com.javeriana.web.four.covet19.Shared.Domain.Mascota.IdMascota;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.IdPersona;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.AgregarCitaMascota.AgregarCitaMascota;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Ports.CitaRepository;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.ValueObjects.DiagnosticoCita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.ValueObjects.FechaCita;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.AgregarCitaVeterinario.AgregarCitaVeterinario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgendarCita {

    private CitaRepository repository;
    private AgregarCitaMascota agregarCitaMascota;
    private AgregarCitaVeterinario agregarCitaVeterinario;


    public AgendarCita(CitaRepository repository, AgregarCitaMascota agregarCitaMascota, AgregarCitaVeterinario agregarCitaVeterinario) {
        this.repository = repository;
        this.agregarCitaMascota = agregarCitaMascota;
        this.agregarCitaVeterinario = agregarCitaVeterinario;
    }
    public void execute(String idCita, String diagnostico, String fechaCita,
                        String idVeterinario, String idMascota){
        if(!repository.find(idCita).isEmpty()){
            throw new RuntimeException("el identificador "+ idCita+ " no es valido");
        }
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fecha = formato.parse(fechaCita);
            agregarCitaVeterinario.execute(idVeterinario, idCita, diagnostico,fechaCita, idMascota);
            agregarCitaMascota.execute(idMascota, idCita, diagnostico, fechaCita,idVeterinario);
            repository.save(Cita.create(new IdCita(idCita), new DiagnosticoCita(diagnostico), new FechaCita(fecha),
                    new IdPersona(idVeterinario), new IdMascota(idMascota)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
