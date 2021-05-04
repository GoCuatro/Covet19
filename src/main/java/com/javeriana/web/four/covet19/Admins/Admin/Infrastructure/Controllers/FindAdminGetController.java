package com.javeriana.web.four.covet19.Admins.Admin.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Admins.Admin.Application.Find.AdminFinder;
import com.javeriana.web.four.covet19.Admins.Admin.Application.Find.AdminFinderResponse;
import com.javeriana.web.four.covet19.Admins.Admin.Application.VerAdmins.AdminVerAdmins;
import com.javeriana.web.four.covet19.Admins.Admin.Application.VerAdmins.AdminVerAdminsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/admins")
public class FindAdminGetController {

    @Autowired
    private AdminFinder finder;

    @GetMapping(value = "/{idAdmin}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap> execute(@PathVariable("idAdmin") String idAdmin)
    {
        AdminFinderResponse response = new AdminFinderResponse(finder.execute(idAdmin));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

}
