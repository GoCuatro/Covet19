package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Pedido.IdPedido;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.IdPersona;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.CompraPedido.Domain.CompraPedido;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects.EnviadoPedido;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects.FechaEnviadoPedido;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects.FechaFinalizadoPedido;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects.FinalizadoPedido;

import java.text.SimpleDateFormat;
import java.util.*;

public class Pedido {
    private IdPedido idPedido;
    private FinalizadoPedido finalizadoPedido;
    private EnviadoPedido enviadoPedido;
    private FechaFinalizadoPedido fechaFinalizadoPedido;
    private FechaEnviadoPedido fechaEnviadoPedido;
    private IdPersona idUsuario;
    private Optional<List<CompraPedido>> compraPedidos;

    public  Pedido(
            IdPedido idPedido,
            FinalizadoPedido finalizadoPedido,
            EnviadoPedido enviadoPedido,
            FechaFinalizadoPedido fechaFinalizadoPedido,
            FechaEnviadoPedido fechaEnviadoPedido,
            IdPersona idUsuario,
            Optional<List<CompraPedido>> compraPedidos
    ){
        this.idPedido = idPedido;
        this.finalizadoPedido = finalizadoPedido;
        this.enviadoPedido = enviadoPedido;
        this.fechaEnviadoPedido = fechaEnviadoPedido;
        this.fechaFinalizadoPedido = fechaFinalizadoPedido;
        this.idUsuario = idUsuario;
        this.compraPedidos = compraPedidos;
    }
    public Pedido create (IdPedido idPedido,
                        FinalizadoPedido finalizadoPedido,
                        EnviadoPedido enviadoPedido,
                        FechaFinalizadoPedido fechaFinalizadoPedido,
                        FechaEnviadoPedido fechaEnviadoPedido,
                        IdPersona idUsuario){
        return new Pedido(idPedido,finalizadoPedido,enviadoPedido,fechaFinalizadoPedido,fechaEnviadoPedido,idUsuario,null);
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("idPedido", idPedido.value());
            put("enviadoPedido", enviadoPedido.value());
            put("fechaEnviadoPedido", fechaEnviadoPedido.value());
            put("finalizadoPedido", finalizadoPedido.value());
            put("fechaFinalizadoPedido", fechaFinalizadoPedido.value());
            put("idUsuario", idUsuario.value());
            put("CompraPedido", "null");
        }};
    }
    public void finalizarPedido(){
        Date fecha = new Date();
        this.finalizadoPedido = new FinalizadoPedido(true);
        this.fechaFinalizadoPedido = new FechaFinalizadoPedido(fecha);

    }
    private Pedido(){}
}
