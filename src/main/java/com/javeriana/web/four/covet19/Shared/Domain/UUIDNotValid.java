package com.javeriana.web.four.covet19.DDD.Shared.Domain;

public class UUIDNotValid extends RuntimeException {
    public UUIDNotValid(String message) {
        super(message);
    }
}