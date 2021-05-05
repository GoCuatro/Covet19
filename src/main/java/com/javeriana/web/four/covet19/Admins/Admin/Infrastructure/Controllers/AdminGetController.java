package com.javeriana.web.four.covet19.Admins.Admin.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Admins.Admin.Application.Find.FindAdmin;
import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping(value = "/admins")
public class AdminGetController {

    @Autowired
    private FindAdmin findAdmin;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, Object>> execute(@PathVariable String id) {
        try {
            Optional<Admin> admin = findAdmin.execute(id);
            if(admin.isEmpty()){
                return ResponseEntity.status(404).body(null);
            }
            return ResponseEntity.ok(admin.get().data());
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(400).body(null);
        }
    }
}
