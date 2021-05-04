package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.BooleanValueObject;

public class EnviadoPedido extends BooleanValueObject {
    private EnviadoPedido() {}

    public EnviadoPedido(Boolean enviado) {
        value = enviado;
    }

}