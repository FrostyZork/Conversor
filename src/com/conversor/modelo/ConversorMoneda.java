package com.conversor.modelo;

import javax.swing.JOptionPane;

public class ConversorMoneda {
    private static Moneda[] monedas;

    public static void main(String[] args) {
        // Inicializa las monedas con sus tasas de cambio
        inicializarMonedas();
        boolean continuar = true;
        while (continuar) {
            int seleccion = mostrarMenu();
            if (seleccion >= 0 && seleccion < monedas.length) {
                double cantidadOrigen = obtenerCantidad("Ingrese la cantidad en " + monedas[seleccion].getNombre() + ":");
                Moneda monedaOrigen = monedas[seleccion];

                int seleccionDestino = mostrarMenu();
                if (seleccionDestino >= 0 && seleccionDestino < monedas.length) {
                    Moneda monedaDestino = monedas[seleccionDestino];
                    double resultado = convertirMoneda(cantidadOrigen, monedaOrigen, monedaDestino);
                    mostrarResultado(cantidadOrigen, monedaOrigen, monedaDestino, resultado);
                    continuar = preguntarSiContinuar();
                } else {
                    continuar = false;
                }
            } else {
                continuar = false;
            }
        }
        JOptionPane.showMessageDialog(null, "Programa Finalizado");
    }

    private static void inicializarMonedas() {
        monedas = new Moneda[]{
            new Moneda("Pesos Mexicanos", "MXN", 1.0),
            new Moneda("Dólar", "USD", 0.058),
            new Moneda("Euro", "EUR", 0.054),
            new Moneda("Libra Esterlina", "LIBRA", 0.047),
            new Moneda("Yen Japonés", "YEN", 8.59),
            new Moneda("Won Sul-Coreano", "WON", 77.39)
        };
    }

    private static int mostrarMenu() {
        String[] opciones = new String[monedas.length];
        for (int i = 0; i < monedas.length; i++) {
            opciones[i] = "Convertir a " + monedas[i].getNombre();
        }

        return JOptionPane.showOptionDialog(
            null,
            "Seleccione una moneda de origen:",
            "Convertidor de Moneda",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );
    }

    private static double obtenerCantidad(String mensaje) {
        double cantidad = 0;
        boolean cantidadValida = false;

        while (!cantidadValida) {
            String input = JOptionPane.showInputDialog(null, mensaje);

            try {
                cantidad = Double.parseDouble(input);
                cantidadValida = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad válida.");
            }
        }

        return cantidad;
    }

    private static double convertirMoneda(double cantidad, Moneda monedaOrigen, Moneda monedaDestino) {
        double cantidadEnPesosMexicanos = cantidad / monedaOrigen.getTasaDeCambio();
        return cantidadEnPesosMexicanos * monedaDestino.getTasaDeCambio();
    }

    private static void mostrarResultado(double cantidadOrigen, Moneda monedaOrigen, Moneda monedaDestino, double resultado) {
        String mensaje = String.format("%.2f %s equivale a %.2f %s", cantidadOrigen, monedaOrigen.getSimbolo(), resultado, monedaDestino.getSimbolo());
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    private static boolean preguntarSiContinuar() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra conversión?", "Continuar", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }
}

