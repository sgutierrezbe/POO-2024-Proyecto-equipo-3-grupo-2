package com.compraservicios.inventario;

import com.compraservicios.producto.Producto;
import com.compraservicios.servicio.Servicio;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;
    private List<Servicio> servicios;

    public Inventario() {
        this.productos = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    // Métodos adicionales
}
