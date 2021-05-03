package com.javeriana.web.four.covet19.Usuarios.HistorialClinico.Infrastructure.Hibernate;

import com.javeriana.web.four.covet19.Shared.Domain.HistorialClinico.IdHistorial;
import com.javeriana.web.four.covet19.Usuarios.HistorialClinico.Domain.HistorialClinico;
import com.javeriana.web.four.covet19.Usuarios.HistorialClinico.Domain.Ports.HistorialClinicoRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateHistorialClinicoRepository implements HistorialClinicoRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<HistorialClinico> aggregateClass;

    public HibernateHistorialClinicoRepository(@Qualifier("session-factory")  SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = HistorialClinico.class;
    }

    @Override
    public void update(HistorialClinico historialClinico) {
        this.sessionFactory.getCurrentSession().update(historialClinico);
    }

    @Override
    public Optional<HistorialClinico> find(String idHistorial) {
        IdHistorial id = new IdHistorial(idHistorial);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(HistorialClinico historialClinico) {
        sessionFactory.getCurrentSession().save(historialClinico);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<HistorialClinico>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("From Historial");
        return Optional.ofNullable(query.list());
    }
}