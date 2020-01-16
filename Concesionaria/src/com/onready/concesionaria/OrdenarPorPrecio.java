package com.onready.concesionaria;

import java.util.Comparator;

public class OrdenarPorPrecio implements Comparator<Vehiculo> {
    public int compare(Vehiculo v1, Vehiculo v2) {
        return (int) (v2.precio - v1.precio);
    }
}