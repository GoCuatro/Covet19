package com.javeriana.web.four.covet19.Admins.Admin.Infrastructure.Hibernate;

import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Admins.Admin.Domain.Port.AdminRepository;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.IdPersona;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateAdminRepository implements AdminRepository {
    protected final SessionFactory sessionFactory;
    protected final Class<Admin>  aggregateClass;

    public HibernateAdminRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Admin.class;
    }

    @Override
    public void update(Admin admin) {
        this.sessionFactory.getCurrentSession().update(admin);
    }

    @Override
    public Optional<Admin> find(String idAdmin) {
        IdPersona id = new IdPersona(idAdmin);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(Admin admin) {
        sessionFactory.getCurrentSession().save(admin);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Admin>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("From Admin");
        return Optional.ofNullable(query.list());
    }
}
