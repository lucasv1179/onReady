package com.onready.helpers;

import java.text.NumberFormat;

public class Helper {
    public static String formatPrice(double price) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMinimumIntegerDigits(2);

        return formatter.format(price);
    }

    public static void imprimirDivisor(char simbolo, int cantidad) {
        for (; cantidad > 0; --cantidad) {
            System.out.print(simbolo);
        }
        System.out.println();
    }
}
