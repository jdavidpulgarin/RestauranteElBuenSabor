/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class ImpresionFactura {

    public static void mostrarCarta() {
        System.out.println("========================================");
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println("========================================");
        int indice = 0;
        while (indice < Datos.nombre.length) {
            System.out.printf("%d. %-22s $%,.0f%n", (indice + 1), Datos.nombre[indice], Datos.precios[indice]);
            indice++;
        }// fin while
        System.out.println("========================================");
    }

    public static void mostrarPedido() {
        double subtotal = 0;
        int indice = 0;
        System.out.println("--- PEDIDO ACTUAL ---");
        while (indice < Datos.nombre.length) {
            if (Datos.cantidad[indice] > 0) {
// imprime producto con cantidad y subtotal parcial
                System.out.printf("%-20s x%-6d $%,.0f%n", Datos.nombre[indice], Datos.cantidad[indice], (Datos.precios[indice] * Datos.cantidad[indice]));
// suma al subtotal
                subtotal = subtotal + Datos.precios[indice] * Datos.cantidad[indice];
            }
            indice++;
        }// fin while
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
    }

    public static void imprimirFacturaCompleta() {
        double subtotal = 0;
        double iva = 0;
        double total = 0;
        double prop = 0;
        int contador = 0;
        double auxiliar = 0;
// calcula subtotal otra vez
        int i = 0;
        while (i < Datos.nombre.length) {
            if (Datos.cantidad[i] > 0) {
                subtotal = subtotal + Datos.precios[i] * Datos.cantidad[i];
                contador = contador + 1;
            }
            i++;
        }// fin while
        if (contador > 3) {
            auxiliar = subtotal - (subtotal * 0.05);
        } else {
            auxiliar = subtotal;
        }
        if (auxiliar > 50000) {
            iva = auxiliar * 0.19;
            total = auxiliar + iva;
            prop = total * 0.10;
            total = total + prop;
        } else {
            iva = auxiliar * 0.19;
            total = auxiliar + iva;
            prop = 0;
        }// fin if-else
        String sep = "========================================";
        System.out.println(sep);
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(sep);
        System.out.printf("FACTURA No. %03d%n", Datos.numeroFactura);
        System.out.println("----------------------------------------");
// imprime cada item del pedido
        int j = 0;
        while (j < Datos.nombre.length) {
            if (Datos.cantidad[j] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n", Datos.nombre[j], Datos.cantidad[j], (Datos.precios[j] * Datos.cantidad[j]));
            }
            j++;
        }// fin while
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", auxiliar);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);
        if (prop > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", prop);
        }// fin if prop
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
        System.out.println(sep);
        System.out.println("Gracias por su visita!");
        System.out.println("El Buen Sabor - Valledupar");
        System.out.println(sep);
// actualiza estado e incrementa factura - tres responsabilidades en un metodo
        Datos.numeroFactura = Datos.numeroFactura + 1;
        Datos.estadoMesa = 0;
        Datos.total = total;
    }

    public static void imprimirFacturaResumen() {
        double sub = 0;
        double iva = 0;
        double tot = 0;
        double prop = 0;
        int cont = 0;
        double aux = 0;
// calcula subtotal otra vez igual que en imprimirFacturaCompleta
        int i = 0;
        while (i < Datos.nombre.length) {
            if (Datos.cantidad[i] > 0) {
                sub = sub + Datos.precios[i] * Datos.cantidad[i];
                cont = cont + 1;
            }
            i++;
        }// fin while
        if (cont > 3) {
            aux = sub - (sub * 0.05);
        } else {
            aux = sub;
        }
        if (aux > 50000) {
            iva = aux * 0.19;
            tot = aux + iva;
            prop = tot * 0.10;
            tot = tot + prop;
        } else {
            iva = aux * 0.19;
            tot = aux + iva;
            prop = 0;
        }// fin if-else
        String sep = "========================================";
        System.out.println(sep);
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(sep);
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", Datos.numeroFactura);
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", aux);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);
        if (prop > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", prop);
        }// fin if prop
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", tot);
        System.out.println(sep);
    }
}
