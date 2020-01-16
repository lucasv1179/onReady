package com.onready.concesionaria;

import com.onready.helpers.Helper;

public class Moto extends Vehiculo {
    public String cilindrada;

    Moto(String marca, String modelo, String cilindrada, double precio) {
        super(marca, modelo, precio);
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + " // " + "Modelo: " + modelo
                + " // " + "Cilindrada: " + cilindrada + " // "
                + "Precio: " + Helper.formatPrice(precio);
    }
}
