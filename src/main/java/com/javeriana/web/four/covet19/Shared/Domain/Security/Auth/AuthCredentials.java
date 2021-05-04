package com.javeriana.web.four.covet19.Shared.Domain.Security.Token;

import java.util.HashMap;

public class AuthCredentials {
    private String subject;
    private String authorities;
    private HashMap<String, Object> claims;

    public AuthCredentials(String subject, String authorities, HashMap<String, Object> claims) {
        this.subject = subject;
        this.authorities = authorities;
        this.claims = claims;
    }

    public String getSubject() {
        return subject;
    }

    public String getAuthorities() {
        return authorities;
    }

    public HashMap<String, Object> getClaims() {
        return claims;
    }
}
