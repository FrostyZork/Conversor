package com.conversor.modelo;

class Moneda {
    private String nombre;
    private String simbolo;
    private double tasaDeCambio;

    public Moneda(String nombre, String simbolo, double tasaDeCambio) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.tasaDeCambio = tasaDeCambio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public double getTasaDeCambio() {
        return tasaDeCambio;
    }
}
