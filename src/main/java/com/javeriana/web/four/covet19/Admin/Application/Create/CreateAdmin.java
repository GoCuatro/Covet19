package com.javeriana.web.four.covet19.Admin.Application.Create;

import com.javeriana.web.four.covet19.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Admin.Infrastructure.Hibernate.HibernateAdminRepository;
import com.javeriana.web.four.covet19.Shared.Domain.Index.Application.Create.CreateIndex;
import com.javeriana.web.four.covet19.Shared.Domain.Index.Infrastructure.Hibernate.HibernateIndexRepository;

import java.util.Date;

public class CreateAdmin {

    private HibernateAdminRepository repository;

    private HibernateIndexRepository indexRepository;

    public CreateAdmin(HibernateAdminRepository repository, HibernateIndexRepository indexRepository) {
        this.repository = repository;
        this.indexRepository = indexRepository;
    }

    public void execute(String idAdmin, long cedulaAdmin, String nombreAdmin, long telefonoAdmin, String correoAdmin, String direccionAdmin, String passwordAdmin, String fechaNacimientoAdmin){
        Admin admin = Admin.create(idAdmin, cedulaAdmin, nombreAdmin, telefonoAdmin, correoAdmin, direccionAdmin, passwordAdmin, fechaNacimientoAdmin);
        repository.save(admin);
        new CreateIndex(indexRepository).execute(correoAdmin, idAdmin, Admin.class.getName());
    }
}
