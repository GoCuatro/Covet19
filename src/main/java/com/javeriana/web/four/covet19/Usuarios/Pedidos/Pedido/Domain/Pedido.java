package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Pedido.IdPedido;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.IdPersona;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects.*;

import java.util.*;
import java.util.stream.Collectors;

public class Pedido {
    private IdPedido idPedido;
    private FinalizadoPedido finalizadoPedido;
    private EnviadoPedido enviadoPedido;
    private FechaFinalizadoPedido fechaFinalizadoPedido;
    private FechaEnviadoPedido fechaEnviadoPedido;
    private IdPersona idUsuario;
    private Optional<List<CompraPedidoDetail>> compraPedidos;



    public  Pedido(
            IdPedido idPedido,
            FinalizadoPedido finalizadoPedido,
            EnviadoPedido enviadoPedido,
            FechaFinalizadoPedido fechaFinalizadoPedido,
            FechaEnviadoPedido fechaEnviadoPedido,
            IdPersona idUsuario,
            List<CompraPedidoDetail> compraPedidos){
        this.idPedido = idPedido;
        this.finalizadoPedido = finalizadoPedido;
        this.enviadoPedido = enviadoPedido;
        this.fechaEnviadoPedido = fechaEnviadoPedido;
        this.fechaFinalizadoPedido = fechaFinalizadoPedido;
        this.idUsuario = idUsuario;
        this.compraPedidos = Optional.ofNullable(compraPedidos);;
    }
    public Pedido create (IdPedido idPedido,
                        FinalizadoPedido finalizadoPedido,
                        EnviadoPedido enviadoPedido,
                        FechaFinalizadoPedido fechaFinalizadoPedido,
                        FechaEnviadoPedido fechaEnviadoPedido,
                        IdPersona idUsuario){
        return new Pedido(idPedido,finalizadoPedido,enviadoPedido,fechaFinalizadoPedido,fechaEnviadoPedido,idUsuario,null);
    }
    public Optional<List<HashMap<String, Object>>> getCompraPedidos() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.compraPedidos.isPresent()) {
            response = Optional.of(this.compraPedidos.get().stream().map(compra -> compra.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public HashMap<String, Object> data() {

        return new HashMap<>() {{
            put("idPedido", idPedido.value());
            put("enviadoPedido", enviadoPedido.value());
            put("fechaEnviadoPedido", fechaEnviadoPedido.value());
            put("finalizadoPedido", finalizadoPedido.value());
            put("fechaFinalizadoPedido", fechaFinalizadoPedido.value());
            put("idUsuario", idUsuario.value());
            put("CompraPedido", getCompraPedidos());
        }};
    }
    public void finalizarPedido(){
        Date fecha = new Date();
        this.finalizadoPedido = new FinalizadoPedido(true);
        this.fechaFinalizadoPedido = new FechaFinalizadoPedido(fecha);

    }
    public void enviarPedido(){
        Date fecha = new Date();
        this.enviadoPedido = new EnviadoPedido(true);
        this.fechaEnviadoPedido = new FechaEnviadoPedido(fecha);
    }
    public Boolean getfinalizadoPedido(){
        return this.finalizadoPedido.value();
    }
    public Boolean getEnviadoPedido(){
        return this.enviadoPedido.value();
    }
    private Pedido(){}

    public String getIdUsiario() {
        return this.idUsuario.value();
    }
}
