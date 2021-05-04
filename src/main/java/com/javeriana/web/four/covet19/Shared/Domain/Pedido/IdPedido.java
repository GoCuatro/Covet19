package com.javeriana.web.four.covet19.Shared.Domain.Pedido;

import com.javeriana.web.four.covet19.Shared.Domain.CustomUUID;

public class IdPedido extends CustomUUID {

    private IdPedido() {
        super("");
    }

    public IdPedido(String value) {
        super(value);
    }
}
