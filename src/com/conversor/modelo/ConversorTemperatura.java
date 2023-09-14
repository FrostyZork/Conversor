package com.conversor.modelo;

import javax.swing.JOptionPane;

public class ConversorTemperatura {

	public static void main(String[] args) {
        int seleccion = mostrarMenu();

        switch (seleccion) {
            case 0:
                convertirCelsiusAFahrenheit();
                break;
            case 1:
                convertirFahrenheitACelsius();
                break;
            case 2:
                convertirCelsiusAKelvin();
                break;
            case 3:
                convertirKelvinACelsius();
                break;
            case 4:
                convertirFahrenheitAKelvin();
                break;
            case 5:
                convertirKelvinAFahrenheit();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Programa Finalizado");
        }
    }

    private static int mostrarMenu() {
        String[] opciones = {
            "Convertir de Celsius a Fahrenheit",
            "Convertir de Fahrenheit a Celsius",
            "Convertir de Celsius a Kelvin",
            "Convertir de Kelvin a Celsius",
            "Convertir de Fahrenheit a Kelvin",
            "Convertir de Kelvin a Fahrenheit",
            "Salir"
        };

        return JOptionPane.showOptionDialog(
            null,
            "Seleccione una opción de conversión:",
            "Conversor de Temperatura",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );
    }

    private static void convertirCelsiusAFahrenheit() {
        double celsius = obtenerTemperatura("Ingrese la temperatura en Celsius:");
        double fahrenheit = (celsius * 9 / 5) + 32;
        mostrarResultado(celsius, "Celsius", fahrenheit, "Fahrenheit");
    }

    private static void convertirFahrenheitACelsius() {
        double fahrenheit = obtenerTemperatura("Ingrese la temperatura en Fahrenheit:");
        double celsius = (fahrenheit - 32) * 5 / 9;
        mostrarResultado(fahrenheit, "Fahrenheit", celsius, "Celsius");
    }

    private static void convertirCelsiusAKelvin() {
        double celsius = obtenerTemperatura("Ingrese la temperatura en Celsius:");
        double kelvin = celsius + 273.15;
        mostrarResultado(celsius, "Celsius", kelvin, "Kelvin");
    }

    private static void convertirKelvinACelsius() {
        double kelvin = obtenerTemperatura("Ingrese la temperatura en Kelvin:");
        double celsius = kelvin - 273.15;
        mostrarResultado(kelvin, "Kelvin", celsius, "Celsius");
    }

    private static void convertirFahrenheitAKelvin() {
        double fahrenheit = obtenerTemperatura("Ingrese la temperatura en Fahrenheit:");
        double kelvin = (fahrenheit + 459.67) * 5 / 9;
        mostrarResultado(fahrenheit, "Fahrenheit", kelvin, "Kelvin");
    }

    private static void convertirKelvinAFahrenheit() {
        double kelvin = obtenerTemperatura("Ingrese la temperatura en Kelvin:");
        double fahrenheit = (kelvin * 9 / 5) - 459.67;
        mostrarResultado(kelvin, "Kelvin", fahrenheit, "Fahrenheit");
    }

    private static double obtenerTemperatura(String mensaje) {
        double temperatura = 0;
        boolean temperaturaValida = false;

        while (!temperaturaValida) {
            String input = JOptionPane.showInputDialog(null, mensaje);

            try {
                temperatura = Double.parseDouble(input);
                temperaturaValida = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una temperatura válida.");
            }
        }

        return temperatura;
    }

    private static void mostrarResultado(double valorOrigen, String unidadOrigen, double valorDestino, String unidadDestino) {
        String mensaje = String.format("%.2f %s equivale a %.2f %s", valorOrigen, unidadOrigen, valorDestino, unidadDestino);
        JOptionPane.showMessageDialog(null, mensaje);
    }
	
}
