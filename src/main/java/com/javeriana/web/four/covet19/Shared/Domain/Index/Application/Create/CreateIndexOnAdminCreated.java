package com.javeriana.web.four.covet19.Shared.Domain.Index.Application.Create;

import com.javeriana.web.four.covet19.Shared.Domain.Admin.AdminCreatedDomainEvent;
import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEventSubscriber;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({AdminCreatedDomainEvent.class})
public class CreateIndexOnAdminCreated {

    private final CreateIndex createIndex;

    public CreateIndexOnAdminCreated(CreateIndex createIndex) {
        this.createIndex = createIndex;
    }

    @EventListener
    public void on(AdminCreatedDomainEvent event) {
        this.createIndex.execute(event.getEmail(), event.aggregateId(), event.getRol());
    }

}
