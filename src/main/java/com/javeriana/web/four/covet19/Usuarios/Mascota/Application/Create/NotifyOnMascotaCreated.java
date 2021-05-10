package com.javeriana.web.four.covet19.Usuarios.Mascota.Application.Create;

import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.four.covet19.Shared.Domain.Citas.CitaCreatedDomainEvent;
import com.javeriana.web.four.covet19.Shared.Domain.Mascota.MascotaCreatedDomainEvent;
import com.javeriana.web.four.covet19.Shared.Domain.Ports.MailSender;
import com.javeriana.web.four.covet19.Shared.Infrastructure.Mail.ElasticEmail.MailSenderElasticEmail;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.Find.MascotaFinder;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Usuarios.User.Application.Find.UserFinder;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.Find.VeterinarioFinder;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@DomainEventSubscriber({MascotaCreatedDomainEvent.class})
public class NotifyOnMascotaCreated {
    MascotaFinder mascotaFinder;
    UserFinder userFinder;
    MailSender sender;

    public NotifyOnMascotaCreated(MascotaFinder mascotaFinder, UserFinder userFinder, MailSenderElasticEmail mailSenderElasticEmail) {
        this.mascotaFinder = mascotaFinder;
        this.userFinder = userFinder;
    }

    @EventListener
    public void on(MascotaCreatedDomainEvent event) {
        User usuario = userFinder.execute(event.getUsuarioId());
        Mascota mascota = mascotaFinder.execute(event.getMascotaId());
        try {
            sender.send(usuario.getUserId().value(), "Agrego una nueva mascota",
                            "Se agrego una nueva mascota  " +
                            mascota.getNombreMascota().value());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
