package com.javeriana.web.four.covet19.Admin.Application.Alll;

import com.javeriana.web.four.covet19.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Admin.Infrastructure.Hibernate.HibernateAdminRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class AllAdmins {

    private HibernateAdminRepository repository;

    public AllAdmins(HibernateAdminRepository repository) {
        this.repository = repository;
    }

    public List<Admin> execute() {
        return repository.all().orElse(new ArrayList<Admin>());
    }
}
