package com.javeriana.web.four.covet19.Shared.Infrastructure.Security.Controllers;


import com.javeriana.web.four.covet19.Shared.Application.Login;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthCredentials;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/login")
public class LoginPostController {

    @Autowired
    private final Login login;
    private final String PASS = "pandillaDeCuatro";
    private final long VALIDITY = 24 * 60 * 60 * 1000;
    @Autowired
    private Environment env;

    public LoginPostController(Login login) {
        this.login = login;
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request) {
        try {
            AuthCredentials credentials = login.execute(request.email, request.pass);
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(credentials.getAuthorities());
            String token = Jwts.builder()
                    .setId(credentials.getSubject())
                    .setSubject(credentials.getSubject())
                    .claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toList()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + VALIDITY))
                    .signWith(SignatureAlgorithm.HS512, PASS.getBytes()).compact();
            return ResponseEntity.status(HttpStatus.OK).body("Bearer " + token);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(400).body(null);
        }
    }

    static class Request {
        private String email;
        private String pass;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }
    }
}
