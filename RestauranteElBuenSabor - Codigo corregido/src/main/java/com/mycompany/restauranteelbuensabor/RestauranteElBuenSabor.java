/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;

/**
 *
 * @author alfre
 */
public class RestauranteElBuenSabor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionMenu = 0;
        boolean sistemaActivo = true;
        int intentosInvalidos = 0;
        double montoUltimoPedido = 0;
        Pedido pedido = new Pedido();

        System.out.println("========================================");
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println("========================================");

        while (sistemaActivo) {
            System.out.println("1. Ver carta");
            System.out.println("2. Agregar producto al pedido");
            System.out.println("3. Ver pedido actual");
            System.out.println("4. Generar factura");
            System.out.println("5. Nueva mesa");
            System.out.println("0. Salir");
            System.out.println("========================================");
            System.out.print("Seleccione una opcion: ");
            opcionMenu = sc.nextInt();

            if (opcionMenu == 1) {

                ImpresionFactura.mostrarCarta();
                System.out.println();

            } else if (opcionMenu == 2) {

                System.out.println("--- AGREGAR PRODUCTO ---");
                System.out.print("Numero de producto (1-" + Carta.getCantidadProductos() + "): ");
                int numeroProducto = sc.nextInt();
                System.out.print("Cantidad: ");
                int cantidadPedida = sc.nextInt();

                if (numeroProducto > 0 && numeroProducto <= Carta.getCantidadProductos()) {
                    if (cantidadPedida > 0) {
                        if (!Mesa.isMesaActiva()) {

                            System.out.print("Ingrese numero de mesa: ");
                            int numeroMesa = sc.nextInt();
                            Mesa.activarMesa(numeroMesa);
                        }

                        Producto productoSeleccionado = Carta.getProducto(numeroProducto - 1);
                        pedido.agregarItem(productoSeleccionado, cantidadPedida);
                        System.out.println("Producto agregado al pedido.");
                        System.out.println("  -> " + productoSeleccionado.getNombre() + " x" + cantidadPedida);
                        montoUltimoPedido = productoSeleccionado.getPrecio() * cantidadPedida;
                    } else {
                        if (cantidadPedida == 0) {

                            System.out.println("La cantidad no puede ser cero.");
                        } else {

                            System.out.println("Cantidad invalida. Ingrese un valor positivo.");
                        }
                    }
                } else {
                    if (numeroProducto <= 0) {
                        System.out.println("El numero debe ser mayor a cero.");
                    } else {
                        System.out.println("Producto no existe. La carta tiene " + Carta.getCantidadProductos() + " productos.");
                    }
                }
                System.out.println();

            } else if (opcionMenu == 3) {

                System.out.println();
                if (pedido.tieneProductos()) {
                    ImpresionFactura.mostrarPedido(pedido);
                } else {
                    System.out.println("No hay productos en el pedido actual.");
                    System.out.println("Use la opcion 2 para agregar productos.");
                }// fin if validar
                System.out.println();

            } else if (opcionMenu == 4) {

                System.out.println();
                if (pedido.tieneProductos()) {

                    Factura factura = new Factura(pedido, Factura.numeroFactura);
                    montoUltimoPedido = factura.calcularTotal();
                    ImpresionFactura.imprimirFacturaCompleta(factura, pedido);
                    Factura.numeroFactura++;
                    Mesa.reiniciar();
                    pedido = new Pedido();
                } else {
                    System.out.println("No se puede generar factura.");
                    System.out.println("No hay productos en el pedido.");
                    System.out.println("Use la opcion 2 para agregar productos primero.");

                    montoUltimoPedido = 0;
                }

            } else if (opcionMenu == 5) {

                System.out.println();
                pedido = new Pedido();
                Mesa.reiniciar();

                montoUltimoPedido = 0;
                intentosInvalidos = 0;
                System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
                System.out.println();

            } else if (opcionMenu == 0) {

                sistemaActivo = false;
                System.out.println("Hasta luego!");

            } else {

                System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
                intentosInvalidos = intentosInvalidos + 1;
                if (intentosInvalidos > 3) {
                    System.out.println("Demasiados intentos invalidos.");
                    intentosInvalidos = 0;
                }
            }
        }
        sc.close();
    }
}
