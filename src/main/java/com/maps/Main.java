package com.maps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException{

        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione tipo de map:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");

        int opcion = sc.nextInt();
        sc.nextLine();

        Map<String, String> inventario = MapFactory.getMap(opcion);
        Inventario.cargarInventario("data/ListadoProducto.txt", inventario);

        Map<String, Integer> carritoMap = MapFactory.getMap(opcion);
        Carrito carrito = new Carrito(carritoMap);

        int eleccion;

        do { 
            System.out.println("\nMENU");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar categoria de producto");
            System.out.println("3. Mostrar carrito");
            System.out.println("4. Mostrar carrito ordenado");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Mostrar inventario  ordenado");
            System.out.println("0. Salir");

            eleccion = sc.nextInt();
            sc.nextLine();

            switch(eleccion){
                case 1:
                    System.out.println("Ingrese categoria: ");
                    String categoria = sc.nextLine().trim();

                    List<String> productosCategoria = new ArrayList<>();

                    for (Map.Entry<String, String> entry : inventario.entrySet()) {
                        if (entry.getValue().equalsIgnoreCase(categoria)) {
                            productosCategoria.add(entry.getKey());
                        }
                    }

                    if (productosCategoria.isEmpty()) {
                        System.out.println("Categoria no existe");
                    } else {
                        System.out.println("Productos disponibles:");
                        for (int i = 0; i < productosCategoria.size(); i++) {
                            System.out.println((i + 1) + ". " + productosCategoria.get(i));
                        }

                        System.out.print("Seleccione producto (numero): ");
                        try {
                            int seleccion = sc.nextInt();
                            sc.nextLine();

                            if (seleccion < 1 || seleccion > productosCategoria.size()) {
                                System.out.println("Seleccion invalida");
                                break;
                            } else {
                                String productoSeleccionado = productosCategoria.get(seleccion - 1);

                                System.out.print("Ingrese cantidad: ");
                                int cantidad = sc.nextInt();
                                sc.nextLine();
                                carrito.agregarProducto(productoSeleccionado, cantidad);
                                System.out.println("Producto agregado correctamente");
                            }
                        } catch (Exception e) {
                            System.out.println("Entrada invalida");
                            sc.nextLine();
                            break;
                        
                            
                        }
                    }
                    break;

                case 2:
                    System.out.println("Ingrese producto: ");
                    String p = sc.nextLine().trim();

                    if (inventario.containsKey(p)){
                        System.out.println("Categoria: " + inventario.get(p));

                    }else {
                        System.out.println("No existe");
                    }
                    break;

                case 3:
                    carrito.mostrarCarrito(inventario);
                    break;

                case 4:
                    carrito.mostrarCarritoOrdenado(inventario);
                    break;
                
                    case 5:
                        for (String key : inventario.keySet()){
                            System.out.println(key + " | " + inventario.get(key));
                        }
                        
                        /*for (int i = 0; i < 10000; i++) {
                            for (String key : inventario.keySet()) {
                                String cat = inventario.get(key);
                            }
                        }
                        break;*/

                    case 6:
                        inventario.entrySet().stream()
                            .sorted((e1, e2) -> inventario.get(e1.getKey()).compareTo(inventario.get(e2.getKey())))
                            .forEach(entry -> {
                                System.out.println(entry.getKey() + " | " + entry.getValue());
                            });

                        /*for (int i = 0; i < 10000; i++) {
                            inventario.entrySet().stream()
                                .sorted(Map.Entry.comparingByValue())
                                .forEach(entry -> {
                                    String k = entry.getKey();
                                    String v = entry.getValue();
                                });
                        }*/
                        break;
    
                        

                

            }

        } while (eleccion !=0);
    }
}