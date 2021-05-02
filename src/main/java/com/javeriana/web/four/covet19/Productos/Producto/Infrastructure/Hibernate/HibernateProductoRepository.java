package com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Hibernate;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Ports.ProductoRepository;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateProductoRepository implements ProductoRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Producto>  aggregateClass;

    public HibernateProductoRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Producto.class;
    }

    @Override
    public void update(Producto producto) {

    }

    @Override
    public Optional<Producto> find(String productoId) {
        return Optional.empty();
    }

    @Override
    public void save(Producto producto) {
        sessionFactory.getCurrentSession().save(producto);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Producto>> all() {
        return Optional.empty();
    }
}
