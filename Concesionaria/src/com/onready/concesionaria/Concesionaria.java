package com.onready.concesionaria;

import com.onready.helpers.Helper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Concesionaria {
    public static void main(String[] args) {
        List<Vehiculo> flota;
        Vehiculo masCaro;
        Vehiculo masBarato;
        List<Vehiculo> modeloY;

        flota = crearFlota();
        masCaro = encontrarMayorPrecio(flota);
        masBarato = encontrarMenorPrecio(flota);
        modeloY = encontrarModeloY(flota);

        imprimirReporte(flota, masCaro, masBarato, modeloY);
    }

    private static List<Vehiculo> crearFlota() {
        List<Vehiculo> lista = new ArrayList<>();
        lista.add(new Auto("Peugeot", "206", 4, 200_000));
        lista.add(new Moto("Honda", "Titan", "125c", 60_000));
        lista.add(new Auto("Peugeot", "208", 5, 250_000));
        lista.add(new Moto("Yamaha", "YBR", "160c", 80_500.50));

        return lista;
    }

    private static Vehiculo encontrarMayorPrecio(List<Vehiculo> flota) {
        Optional<Vehiculo> max = flota
                .stream()
                .reduce((vehiculo1, vehiculo2) ->
                        vehiculo1.precio > vehiculo2.precio ? vehiculo1 : vehiculo2
                );
        return max.orElse(null);
    }

    private static Vehiculo encontrarMenorPrecio(List<Vehiculo> flota) {
        Optional<Vehiculo> min = flota
                .stream()
                .reduce((vehiculo1, vehiculo2) ->
                        vehiculo1.precio > vehiculo2.precio ? vehiculo2 : vehiculo1
                );
        return min.orElse(null);
    }

    private static List<Vehiculo> encontrarModeloY(List<Vehiculo> flota) {
        List<Vehiculo> lista;
        lista = flota
                .stream()
                .filter(vehiculo -> vehiculo.contieneSequencia("Y"))
                .collect(Collectors.toList());
        return lista;
    }

    private static void imprimirReporte(List<Vehiculo> flota, Vehiculo masCaro,
                                        Vehiculo masBarato, List<Vehiculo> modeloY) {

        flota.forEach(vehiculo -> System.out.println(vehiculo));
        Helper.imprimirDivisor('=', 29);

        if (masCaro != null && masBarato != null) {
            System.out.println("Vehículo más caro: " + masCaro.marca + " " + masCaro.modelo);
            System.out.println("Vehículo más barato: " + masBarato.marca + " " + masBarato.modelo);
        }
        System.out.print("Vehículo que contiene en el modelo la letra 'Y': ");
        modeloY.forEach(vehiculo ->
                System.out.println(
                    vehiculo.marca + " "
                    + vehiculo.modelo + " "
                    + Helper.formatPrice(vehiculo.precio)
                )
        );
        Helper.imprimirDivisor('=', 29);

        System.out.println("Vehículos ordenados por precio de mayor a menor:");
        flota.sort(new OrdenarPorPrecio());
        flota.forEach(vehiculo -> System.out.println(vehiculo.marca + " " + vehiculo.modelo));
    }
}
