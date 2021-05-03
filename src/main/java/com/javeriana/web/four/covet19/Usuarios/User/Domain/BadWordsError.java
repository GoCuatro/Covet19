package com.javeriana.web.four.covet19.Usuarios.User.Domain;

public class BadWordsError extends RuntimeException {
    public BadWordsError(String mesagge) {
        super(mesagge);
    }
}
