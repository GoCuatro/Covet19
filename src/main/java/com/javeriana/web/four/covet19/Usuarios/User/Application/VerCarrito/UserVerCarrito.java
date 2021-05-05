package com.javeriana.web.four.covet19.Usuarios.User.Application.VerCarrito;

import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.UserNotExist;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.UserRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects.ElementoCarritoUsuario;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Exceptions.VeterinarioNoExiste;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class UserVerCarrito {

    private UserRepository repository;

    public UserVerCarrito(UserRepository repository) {
        this.repository = repository;
    }

    public List<HashMap<String, Object>> execute(String idUsuario)
    {
        Optional<User> usuario = repository.find(idUsuario);
        if (usuario.isEmpty())
        {
            throw new UserNotExist(idUsuario);
        }
        List<HashMap<String, Object>> result = new ArrayList<>();
        User finalUser = usuario.get();
        if(!finalUser.getUserCarrito().isEmpty()) {
            result = finalUser.getUserCarrito().get();
        }
        return result;
    }

}
