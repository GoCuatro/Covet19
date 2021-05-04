package com.javeriana.web.four.covet19.Shared.Domain.Security.Auth;

import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.Exceptions.IncorrectCredentials;

public interface AuthEntity {
    public AuthCredentials getCredentials(String supposedPass) throws IncorrectCredentials;
}