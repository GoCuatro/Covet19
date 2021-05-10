package com.javeriana.web.four.covet19.Usuarios.User.Application.VerCitasAgendadas;

import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.UserNotExist;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.UserRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;

import java.util.Optional;

public class VerCitasAgendadas {
    private final UserRepository repository;

    public VerCitasAgendadas(UserRepository repository) {
        this.repository = repository;
    }
    public void execute(String idUsuario){
        Optional<User> usuario = repository.find(idUsuario);
        if(usuario.isEmpty()){
            throw new UserNotExist(idUsuario);
        }
        User finalUsuario = usuario.get();

    }
}
