package com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Infrastructure.Hibernate;

import com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Domain.Index;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Domain.Ports.IndexRepository;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Index.Domain.ValueObjects.RefererenceValueObject;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class HibernateIndexRepository implements IndexRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Index>  aggregateClass;

    public HibernateIndexRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Index.class;
    }

    @Override
    public Optional<Index> find(String referenceId) {
        return sessionFactory.getCurrentSession().byId(aggregateClass).loadOptional(new RefererenceValueObject(referenceId));
    }

    @Override
    public void save(Index index) {
        sessionFactory.getCurrentSession().save(index);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }
}
