package com.onready.concesionaria;

public abstract class Vehiculo implements Identificable{
    public String marca;
    public String modelo;
    public double precio;

    Vehiculo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    @Override
    public boolean contieneSequencia(String sequencia) {
        return modelo.contains(sequencia);
    }
}
