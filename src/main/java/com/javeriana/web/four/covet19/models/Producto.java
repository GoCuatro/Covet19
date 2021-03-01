package com.javeriana.web.four.covet19.models;

import javax.persistence.*;

@Entity
@Table(name = "Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "identificador", nullable = false)
    private String identificador;
    @Column(name = "precio", nullable = false)
    private double precio;
    @Column(name = "inventario", nullable = false)
    private int inventario;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "marca", nullable = false)
    private String marca;

    public Producto(String identificador, double precio, int inventario, String descripcion, String marca) {
        this.id = id;
        this.identificador = identificador;
        this.precio = precio;
        this.inventario = inventario;
        this.descripcion = descripcion;
        this.marca = marca;
    }

    public Producto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return String.format("id: %d, identificador: %s, descripcion: %s, marca: %s", this.id, this.identificador, this.descripcion, this.marca);
    }
}
