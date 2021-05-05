package com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Productos.Producto.Application.Delete.DeleteProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producto")
public class DeleteDeleteController {

    @Autowired
    private DeleteProducto deleteProducto;

    @DeleteMapping(value = "")
    public ResponseEntity execute(@RequestParam String id) {
        try {
            deleteProducto.execute(id);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }
}
