package com.javeriana.web.four.covet19.Usuarios.User.Domain;

public class UserNotExist extends RuntimeException {
    public UserNotExist(String message) {
        super(message);
    }
}
