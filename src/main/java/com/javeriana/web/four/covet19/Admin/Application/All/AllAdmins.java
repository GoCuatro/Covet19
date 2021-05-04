package com.javeriana.web.four.covet19.Admin.Application.All;

import com.javeriana.web.four.covet19.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Admin.Infrastructure.Hibernate.HibernateAdminRepository;

import java.util.ArrayList;
import java.util.List;

public class AllAdmins {

    private HibernateAdminRepository repository;

    public AllAdmins(HibernateAdminRepository repository) {
        this.repository = repository;
    }

    public List<Admin> execute() {
        return repository.all().orElse(new ArrayList<Admin>());
    }
}
