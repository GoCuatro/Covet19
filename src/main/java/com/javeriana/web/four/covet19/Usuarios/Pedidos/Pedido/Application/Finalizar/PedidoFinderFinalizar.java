package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.Finalizar;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Exceptions.MascotaNotExist;

import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Exceptions.PedidoFinalizado;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Exceptions.PedidoNotExist;
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
            throw new PedidoNotExist("The pedido " + id + " not exists");
        }
        Pedido pedidoUpdate = pedido.get();
        if(!pedidoUpdate.getfinalizadoPedido()){
            pedidoUpdate.finalizarPedido();
            repository.update(pedidoUpdate);
        }else{
            throw new PedidoFinalizado("The pedido " + id + " is already finished");
        }

    }
}
