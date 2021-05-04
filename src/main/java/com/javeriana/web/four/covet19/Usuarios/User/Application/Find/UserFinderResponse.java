package com.javeriana.web.four.covet19.Usuarios.User.Application.Find;

import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;
import com.javeriana.web.four.covet19.Shared.Application.Response;

import java.util.HashMap;

public class UserFinderResponse implements Response {

    private User user;

    public UserFinderResponse(User user) {
        this.user = user;
    }

    public HashMap response()
    {
        HashMap response = this.user.data();
        response.remove("id");
        return response;
    }
}
