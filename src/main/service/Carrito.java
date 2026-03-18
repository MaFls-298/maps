package main.service;
import java.util.*;


public class Carrito {
    private Map<String, Integer> carrito;

    public Carrito(){
        carrito = new HashMap<>();

    }

    public void agregarProducto(String producto){
        carrito.put(producto, carrito.getORDefault(producto, 0)+1)


    }

    public void mostrarCarrito(Map<String, String>inventario){
        for (String producto : carrito.keySet()){
            System.out.println(producto + " | " + inventario.get(producto)+ "| Cantidad: " + carito.get(prodcuto));

        }
    }

    public void mostrarCarritoOrdenado(Map<String, String> inventario){
        carrito.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    String producto = entry.getKey();
                    System.err.println(producto + " | " + inventario.get(producto) + " | Cantidad: " + entry.getValue());
                });

    }


    
}
