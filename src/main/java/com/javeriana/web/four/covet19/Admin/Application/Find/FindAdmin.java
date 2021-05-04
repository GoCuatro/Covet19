package com.javeriana.web.four.covet19.Admin.Application.Find;

import com.javeriana.web.four.covet19.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Admin.Infrastructure.Hibernate.HibernateAdminRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindAdmin {

    private HibernateAdminRepository repository;

    public FindAdmin(HibernateAdminRepository repository) {
        this.repository = repository;
    }

    public Optional<Admin> execute(String idAdmin) {
        return repository.find(idAdmin);
    }
}
