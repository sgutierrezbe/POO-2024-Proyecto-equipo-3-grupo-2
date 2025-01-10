package com.compraservicios.servicio;

public class Servicio {
    private String nombre;
    private double costo;
    private int duracion;

    public Servicio(String nombre, double costo, int duracion) {
        this.nombre = nombre;
        this.costo = costo;
        this.duracion = duracion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
