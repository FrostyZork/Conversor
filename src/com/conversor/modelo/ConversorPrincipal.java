package com.conversor.modelo;

import javax.swing.JOptionPane;

public class ConversorPrincipal {
    public static void main(String[] args) {
        int seleccion = mostrarMenuPrincipal();

        switch (seleccion) {
            case 0:
                ejecutarConversorMoneda();
                break;
            case 1:
                ejecutarConversorTemperatura();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Programa Finalizado");
        }
    }

    private static int mostrarMenuPrincipal() {
        String[] opciones = {
            "Conversor de Moneda",
            "Conversor de Temperatura",
            "Salir"
        };

        return JOptionPane.showOptionDialog(
            null,
            "Seleccione una opción:",
            "Conversor Principal",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );
    }

    private static void ejecutarConversorMoneda() {
        ConversorMoneda.main(new String[]{});
    }

    private static void ejecutarConversorTemperatura() {
        ConversorTemperatura.main(new String[]{});
    }
}

