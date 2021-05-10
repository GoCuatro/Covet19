package com.javeriana.web.four.covet19.Usuarios.Mascota.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.Create.MascotaCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mascotas")
public class CreateMascotaPostController {
    @Autowired
    private MascotaCreator creator;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request) {
        creator.execute(request.getId(), request.getNombre(), request.getEdad(), request.getPeso(), request.getTipo(), request.getRaza());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class Request {
        private String id;
        private String nombre;
        private double peso;
        private int edad;
        private String tipo;
        private String raza;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public void getTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getRaza() {
            return raza;
        }

        public void getRaza(String raza) {
            this.raza = raza;
        }

        public Integer getEdad() {
            return edad;
        }

        public void setEdad(Integer edad) {
            this.edad = edad;
        }

        public Double getPeso() {
            return peso;
        }

        public void getDouble(Double peso) {
            this.peso = peso;
        }
    }
}
