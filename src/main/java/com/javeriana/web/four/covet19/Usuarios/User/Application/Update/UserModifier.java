package com.javeriana.web.four.covet19.Usuarios.User.Application.Update;

import com.javeriana.web.four.covet19.Usuarios.User.Domain.*;

import java.util.Optional;

public class UserModifier {

    private UserRepository repository;
    private UserDomainFinder finder;
    private UserValidateWords validator;
    private ValidateWordService service;

    public UserModifier(UserRepository repository, ValidateWordService service) {
        this.repository = repository;
        this.service = service;
        this.finder = new UserDomainFinder(repository);
        this.validator = new UserValidateWords(service);
    }

    public void execute(String userId, String userFirstName, String userLastName, String userNickName)
    {
        validator.execute(new UserNickName(userNickName).value());
        Optional<User> actualUser = finder.execute(userId);
        User oldUser = actualUser.get();
        oldUser.updateUser(new UserName(userFirstName), new UserLastName(userLastName), new UserNickName(userNickName));
        repository.update(userId, oldUser);
    }
}
