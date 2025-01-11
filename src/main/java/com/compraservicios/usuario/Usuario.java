package com.compraservicios.usuario;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String identificacion;
    private int edad;
    private String genero;
    private List<String> historialCompras;

    // Constructor
    public Usuario(String nombre, String identificacion, int edad, String genero) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.genero = genero;
        this.historialCompras = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<String> getHistorialCompras() {
        return historialCompras;
    }

    // Métodos adicionales
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public void agregarCompra(String producto) {
        historialCompras.add(producto);
    }

    public void mostrarHistorialCompras() {
        if (historialCompras.isEmpty()) {
            System.out.println("El historial de compras está vacío.");
        } else {
            System.out.println("Historial de compras:");
            for (String compra : historialCompras) {
                System.out.println("- " + compra);
            }
        }
    }

    public boolean solicitarDevolucion(String producto) {
        if (historialCompras.contains(producto)) {
            historialCompras.remove(producto);
            System.out.println("Devolución del producto " + producto + " realizada con éxito.");
            return true;
        } else {
            System.out.println("El producto " + producto + " no se encuentra en el historial de compras.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                '}';
    }
}
