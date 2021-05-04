package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.BooleanValueObject;


public class FinalizadoPedido extends BooleanValueObject {
    private FinalizadoPedido() {}

    public FinalizadoPedido(Boolean finalizado) {
        value = finalizado;
    }

}
