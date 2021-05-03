package com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Productos.Producto.Application.Find.FindProducto;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping(value = "/producto")
public class ProductoGetController {

    @Autowired
    private FindProducto findProducto;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, Object>> execute(@RequestParam String id) {
        try {
            Optional<Producto> producto = findProducto.execute(id);
            if (producto.isEmpty()) {
                return ResponseEntity.status(404).body(null);
            }
            return ResponseEntity.ok(producto.get().data());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }
}
