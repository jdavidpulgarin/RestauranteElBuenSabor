/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class CalculadorFactura {

    public static double calcularTotalFactura() {
        double subtotal = 0;
        double iva = 0;
        double total = 0;
        double auxiliar = 0;
        int contador = 0;
        int indice = 0;
        while (indice < Datos.nombre.length) {
            if (Datos.cantidad[indice] > 0) {
// multiplica precio por cantidad
                subtotal = subtotal + Datos.precios[indice] * Datos.cantidad[indice];
                contador = contador + 1;
            }
            indice++;
        }// fin while
        if (contador > 3) {
            if (subtotal > 0) {
                auxiliar = subtotal - (subtotal * 0.05);
                if (auxiliar > 50000) {
                    iva = auxiliar * 0.19;
// suma iva al subtotal con descuento
                    total = auxiliar + iva;
                    total = total + (total * 0.10);
                } else {
// suma iva al subtotal
                    iva = auxiliar * 0.19;
                    total = auxiliar + iva;
                }
            }// fin if sub>0
// version anterior - no borrar
// sub = sub * 1.19;
// if(sub > 40000) sub = sub + (sub*0.10);
// return sub;
        } else {
            if (subtotal > 50000) {
                iva = subtotal * 0.19;
// suma iva al subtotal
                total = subtotal + iva;
                total = total + (total * 0.10);
            } else {
                iva = subtotal * 0.19;
                total = subtotal + iva;
            }
        }// fin if-else cont
        Datos.estadoMesa = 1;
        Datos.total = total;
        return total;
    }

    public static double procesar(double a, double b, double c, double d, double e, int f, boolean g) {
        double res = 0;
        double iva = 0;
        double prop = 0;
        double tmp = 0;
// calcula subtotal con cantidad
        res = a * b;
        if (c > 0) {
// aplica descuento
            res = res - (res * c);
        }
// calcula iva
        iva = res * d;
        tmp = iva;
        res = res + tmp;
        if (g) {
// aplica propina si corresponde
            prop = res * e;
            res = res + prop;
        }
        if (f > 3) {
            res = res - (res * 0.01);
        }
        return res;
    }
}
