package com.javeriana.web.four.covet19.Shared.Domain.Mascota;

import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class MascotaCreatedDomainEvent extends DomainEvent {

    private String mascotaId;
    private String usuarioId;

    public MascotaCreatedDomainEvent() {
    }

    public MascotaCreatedDomainEvent(String aggregateId, String mascotaId, String usuarioId) {
        super(aggregateId);
        this.mascotaId = mascotaId;
        this.usuarioId = usuarioId;
    }

    public MascotaCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String mascotaId, String usuarioId) {
        super(aggregateId, eventId, occurredOn);
        this.mascotaId = mascotaId;
        this.usuarioId = usuarioId;

    }

    public String getMascotaId() {
        return mascotaId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    @Override
    public String eventName() {
        return "mascota.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
            put("mascotaId", mascotaId);
            put("usuarioId", usuarioId);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new MascotaCreatedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("mascotaId"), (String) body.get("usuarioId") );
    }
}
