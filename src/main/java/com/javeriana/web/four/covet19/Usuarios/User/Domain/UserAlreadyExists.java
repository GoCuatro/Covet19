package com.javeriana.web.four.covet19.Usuarios.User.Domain;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists(String message) {
        super(message);
    }
}
