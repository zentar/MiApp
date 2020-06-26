package com.pm.miapp;

public class Estacion {
    private String nombre;
    private String estacionAnterior;
    private String stacionSiguiente;
    private int icono;

    public Estacion(String nombre, String estacionAnterior, String stacionSiguiente, int icono) {
        this.nombre = nombre;
        this.estacionAnterior = estacionAnterior;
        this.stacionSiguiente = stacionSiguiente;
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstacionAnterior() {
        return estacionAnterior;
    }

    public void setEstacionAnterior(String estacionAnterior) {
        this.estacionAnterior = estacionAnterior;
    }

    public String getStacionSiguiente() {
        return stacionSiguiente;
    }

    public void setStacionSiguiente(String stacionSiguiente) {
        this.stacionSiguiente = stacionSiguiente;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }
}
