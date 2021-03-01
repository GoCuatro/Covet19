package com.javeriana.web.four.covet19.controllers;

import com.javeriana.web.four.covet19.models.Producto;
import com.javeriana.web.four.covet19.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    private ProductoService service;

    @Autowired
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> getProductos(){
        List<Producto> productos = null;
        try{
            productos = this.service.getAll();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> addProducto(@RequestBody Producto producto){
        System.out.println(producto.toString());
        Producto productoCreado = null;
        try{
            productoCreado = this.service.addProducto(producto);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return ResponseEntity.status(HttpStatus.OK).body(productoCreado);
    }
}
