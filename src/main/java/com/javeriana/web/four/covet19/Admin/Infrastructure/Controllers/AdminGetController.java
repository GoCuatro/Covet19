package com.javeriana.web.four.covet19.Admin.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Admin.Application.All.AllAdmins;
import com.javeriana.web.four.covet19.Admin.Application.Find.FindAdmin;
import com.javeriana.web.four.covet19.Admin.Domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/admin")
public class AdminGetController {

    @Autowired
    private FindAdmin findAdmin;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, Object>> execute(@RequestParam String id) {
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
