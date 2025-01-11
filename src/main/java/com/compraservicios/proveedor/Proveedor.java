package com.compraservicios.proveedor;

import com.compraservicios.producto.Producto;
import com.compraservicios.servicio.Servicio;
import java.util.List;

public class Proveedor {
    private String nombre;
    private List<Producto> productos;
    private List<Servicio> servicios;

    public Proveedor(String nombre, List<Producto> productos, List<Servicio> servicios) {
        this.nombre = nombre;
        this.productos = productos;
        this.servicios = servicios;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}
