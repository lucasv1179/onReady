package com.onready.concesionaria;

import com.onready.helpers.Helper;

public class Auto extends Vehiculo {
    public int puertas;

    Auto(String marca, String modelo, int puertas, double precio) {
        super(marca, modelo, precio);
        this.puertas = puertas;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + " // " + "Modelo: " + modelo
                + " // " + "Puertas: " + puertas + " // "
                + "Precio: " + Helper.formatPrice(precio);
    }
}
