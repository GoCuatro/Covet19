package com.javeriana.web.four.covet19.Shared.Application;

import com.javeriana.web.four.covet19.Admins.Admin.Application.Find.FindAdmin;
import com.javeriana.web.four.covet19.Productos.Producto.Application.Exceptions.NotFound;
import com.javeriana.web.four.covet19.Shared.Domain.Index.Domain.Index;
import com.javeriana.web.four.covet19.Shared.Domain.Index.Domain.Ports.IndexRepository;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthCredentials;
import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import java.util.Optional;

public class Login {

    IndexRepository repository;
    FindAdmin findAdmin;

    public Login(IndexRepository repository, FindAdmin findAdmin) {
        this.repository = repository;
        this.findAdmin = findAdmin;
    }

    public AuthCredentials execute(String email, String pass){
        Optional<Index> index = repository.find(email);
        if(index.isEmpty()){
            throw new NotFound("Email no registrado");
        }
        if (Admin.class.getName().equals(index.get().getRolValueObject())) {
            Optional<Admin> admin = findAdmin.execute(index.get().getRefererenceValueObject());
            if(admin.isEmpty()){
                throw new NotFound("Administrador no encontrado");
            }
            return admin.get().getCredentials(pass);
        }
        return null;
    }

}
