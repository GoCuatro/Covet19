package com.javeriana.web.four.covet19.Admins.Admin.Domain.Exceptions;

import com.javeriana.web.four.covet19.Admins.Admin.Application.Find.AdminFinder;

public class AdminNoExiste extends RuntimeException{

    public AdminNoExiste(String idAdmin) {
        super("El Admin con Id: " + idAdmin + " no existe");
    }

}
