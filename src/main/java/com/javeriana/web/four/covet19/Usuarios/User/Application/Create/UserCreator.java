package com.javeriana.web.four.covet19.Usuarios.User.Application.Create;

import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.*;
import com.javeriana.web.four.covet19.Usuarios.User.Application.UserDomainFinder.UserDomainFinder;
import com.javeriana.web.four.covet19.Usuarios.User.Application.UserValidateWords.UserValidateWords;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.*;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.UserNotExist;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.UserRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.ValidateWordService;

import java.util.Date;

public class UserCreator {
    private UserRepository repository;
    private ValidateWordService service;
    private UserValidateWords validator;
    private UserDomainFinder finder;

    public UserCreator(UserRepository repository, ValidateWordService service) {
        this.repository = repository;
        this.service = service;
        this.validator = new UserValidateWords(service);
        this.finder = new UserDomainFinder(repository);
    }

    public void execute(String userId, String userFirstName, String userPassword,
                        String  userMail, long userPhone, long userCedule,
                        String userAdresss, Date userBirth)
    {
        this.validate(userId);
        validator.execute(new NombrePersona(userFirstName).value());
        User user = User.create(new IdPersona(userId), new NombrePersona(userFirstName),
                new PasswordPersona(userPassword) , new CorreoPersona(userMail),
                new TelefonoPersona(userPhone), new CedulaPersona(userCedule),
                new DireccionPersona(userAdresss), new FechaNacimientoPersona(userBirth));
        repository.save(user);
    }

    private void validate(String UserId)
    {
        try
        {
            this.finder.execute(UserId);
        }
        catch (UserNotExist exception) { }
    }
}
