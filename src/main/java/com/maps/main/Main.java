package com.maps.main;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import com.maps.factory.MapFactory;
import com.maps.model.Inventario;
import com.maps.service.Carrito;

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

        Carrito carrito = new Carrito();
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
                    System.out.println("Ingrese producto: ");
                    String prod = sc.nextLine().trim();

                    if (inventario.containsKey(prod)){
                        System.out.print("Ingrese cantidad: ");
                        int cantidad = sc.nextInt();
                        sc.nextLine();
                        carrito.agregarProducto(prod, cantidad);
                        System.out.println("Se agrego el producto");

                    }else{
                        System.out.println("Producto no existe");
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
                        break;

                    case 6:
                        inventario.entrySet().stream()
                            .sorted(Map.Entry.comparingByValue())
                            .forEach(entry -> {
                                System.out.println(entry.getKey() + " | " + entry.getValue());
                            });
                        break;
    
                        

                

            }

        } while (eleccion !=0);
    }
}