package com.onready.helpers;

import java.text.NumberFormat;

public class Helper {
    public static String formatPrice(double price) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMinimumIntegerDigits(2);

        return formatter.format(price);
    }

    public static void imprimirDivisor(char c, int numero) {
        for (; numero > 0; --numero) {
            System.out.print(c);
        }
        System.out.println();
    }
}
