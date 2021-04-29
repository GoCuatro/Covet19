package com.javeriana.web.four.covet19.Shared.Productos;

import com.javeriana.web.four.covet19.Shared.Domain.CustomUUID;

public class ProductoId extends CustomUUID {
    private ProductoId() {
        super("");
    }

    public ProductoId(String value) {
        super(value);
    }
}