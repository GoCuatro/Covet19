package com.javeriana.web.four.covet19.Veterinarios.Cita.Application.Create;

import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.four.covet19.Shared.Domain.Citas.CitaCreatedDomainEvent;
import com.javeriana.web.four.covet19.Shared.Domain.Ports.MailSender;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.Find.MascotaFinder;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.Find.VeterinarioFinder;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@DomainEventSubscriber({CitaCreatedDomainEvent.class})
public class NotifyOnCitaCreated {
    VeterinarioFinder veterinarioFinder;
    MascotaFinder mascotaFinder;
    MailSender sender;

    public NotifyOnCitaCreated(VeterinarioFinder veterinarioFinder, MascotaFinder mascotaFinder, MailSender sender) {
        this.veterinarioFinder = veterinarioFinder;
        this.mascotaFinder = mascotaFinder;
        this.sender = sender;
    }

    @EventListener
    public void on(CitaCreatedDomainEvent event) {
        Veterinario veterinario = veterinarioFinder.execute(event.getVeterinarioId());
        Mascota mascota = mascotaFinder.execute(event.getMascotaId());
        try {
            sender.send(veterinario.getCorreoVeterinario(), "Cita agendada " + event.getFecha().toString(),
                    "Se ha agendado una cita el " +
                            event.getFecha().toString() +
                            " con la mascota " +
                            mascota.getNombreMascota());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
