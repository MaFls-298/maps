import factory.MapFactory;
import model.Inventario;
import service.Carrito;

import java.util.*;
import main.factory.MapFactory;
import main.model.Inventario;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione tipo de map:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");

        int opcion = sc.nextInt();
        sc.nextLine()

        Map<String, String> inventario = MapFactory.getMap(opcion);
        inventario = Inventario.cargarInventario("data/inventario.txt",inventario);

        main.service.Carrito carrito = new Carrito();
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

            switch(choice){
                case 1:
                    System.out.println("Ingrese producto: ");
                    String prod = sc.nextLine();

                    if (inventario.containsKey(prod)){
                        carrito.agregarProducto(prod);
                        System.out.println("Se agrego el producto");

                    }else{
                        System.out.println("Producto no existe");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese producto: ");
                    String p = sc.nextLine();

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
                        for (String key : inventario.KeySet()){
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

        } while (choice !=0);
    }
}