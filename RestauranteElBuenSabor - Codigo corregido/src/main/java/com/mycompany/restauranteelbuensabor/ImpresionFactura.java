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

    private static final String NOMBRE_RESTAURANTE = "El Buen Sabor";
    private static final String DIRECCION = "Calle 15 #8-32, Valledupar";
    private static final String NIT = "900.123.456-7";

    private static void imprimirEncabezado() {
        System.out.println("========================================");
        System.out.println("    RESTAURANTE " + NOMBRE_RESTAURANTE);
        System.out.println("    " + DIRECCION);
        System.out.println("    NIT: " + NIT);
        System.out.println("========================================");
    }

    public static void mostrarCarta() {
        imprimirEncabezado();
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println("========================================");
        int indiceProducto = 0;
        while (indiceProducto < Carta.getCantidadProductos()) {
            Producto producto = Carta.getProducto(indiceProducto);
            System.out.printf("%d. %-22s $%,.0f%n", (indiceProducto + 1), producto.getNombre(), producto.getPrecio());
            indiceProducto++;
        }
        System.out.println("========================================");
    }

    public static void mostrarPedido(Pedido pedido) {
        System.out.println("--- PEDIDO ACTUAL ---");
        int indiceItem = 0;
        while (indiceItem < pedido.getItems().size()) {
            ItemPedido item = pedido.getItems().get(indiceItem);
            System.out.printf("%-20s x%-6d $%,.0f%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    item.calcularSubtotal());
            indiceItem++;
        }
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", pedido.calcularSubtotal());
    }

    private static void imprimirItemsPedido(Pedido pedido) {
        // imprime cada item del pedido
        int indiceItem = 0;
        while (indiceItem < pedido.getItems().size()) {
            ItemPedido item = pedido.getItems().get(indiceItem);
            System.out.printf("%-20s x%-6d $%,.0f%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    item.calcularSubtotal());
            indiceItem++;
        }
    }

    private static void imprimirTotales(Factura factura) {
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", factura.calcularSubtotal() - factura.calcularDescuento());
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", factura.calcularIVA());
        if (factura.calcularPropina() > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", factura.calcularPropina());
        }// fin if prop
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", factura.calcularTotal());
    }

    public static void imprimirFacturaCompleta(Factura factura, Pedido pedido) {
        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d%n", factura.getNumero());
        System.out.println("----------------------------------------");
        imprimirItemsPedido(pedido);
        imprimirTotales(factura);
        System.out.println("Gracias por su visita!");
        System.out.println("El Buen Sabor - Valledupar");
        System.out.println("========================================");

      
    }

    public static void imprimirFacturaResumen(Factura factura) {
        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", factura.getNumero());
        System.out.println("----------------------------------------");
        imprimirTotales(factura);
    }
}
