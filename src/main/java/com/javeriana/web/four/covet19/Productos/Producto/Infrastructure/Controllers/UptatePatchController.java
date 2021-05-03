package com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Productos.Producto.Application.Create.ProductoCreator;
import com.javeriana.web.four.covet19.Productos.Producto.Application.Update.UpdateProducto;
import com.javeriana.web.four.covet19.Productos.Producto.Application.Update.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/producto")
public class UptatePatchController {

    @Autowired
    private UpdateProducto updateProducto;

    @PatchMapping(value = "")
    public ResponseEntity execute(@RequestBody UpdateRequest request) {
        try {
            updateProducto.execute(request);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }
}
