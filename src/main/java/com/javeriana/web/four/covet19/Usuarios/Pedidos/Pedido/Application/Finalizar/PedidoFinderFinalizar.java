package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.Finalizar;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Exceptions.MascotaNotExist;

import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Pedido;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Ports.PedidoRepository;

import java.util.Optional;

public class PedidoFinderFinalizar {

    private PedidoRepository repository;

    public PedidoFinderFinalizar(PedidoRepository repository) {
        this.repository = repository;
    }

    public void execute(String id) {
        Optional<Pedido> pedido = repository.find(id);
        if (pedido.isEmpty()) {
            throw new MascotaNotExist("The product " + id + " not exists");
        }
        Pedido pedidoUpdate = pedido.get();
        pedidoUpdate.finalizarPedido();
        repository.update(pedidoUpdate);
    }
}
