/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author Pulgarin
 */
public class Mesa {

    private static int numeroMesaActual = 0;
    private static boolean mesaActiva = false;

    public static int getNumeroMesaActual() {
        return numeroMesaActual;
    }

    public static boolean isMesaActiva() {
        return mesaActiva;
    }

    public static void activarMesa(int numeroMesa) {
        if (numeroMesa > 0) {
            numeroMesaActual = numeroMesa;
        } else {
            
            numeroMesaActual = 1;
        }
        mesaActiva = true;
    }

    public static void reiniciar() {
        numeroMesaActual = 0;
        mesaActiva = false;
    }
}
