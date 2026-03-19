package com.maps;
import java.util.Map;


public class Carrito {
    private Map<String, Integer> carrito;

    public Carrito(Map<String, Integer> carritoMap){
        this.carrito = carritoMap;
    }


    public void agregarProducto(String producto, int cantidad){
        carrito.put(producto, carrito.getOrDefault(producto, 0)+cantidad);


    }

    public void mostrarCarrito(Map<String, String>inventario){
        for (String producto : carrito.keySet()){
            System.out.println(producto + " | " + inventario.get(producto)+ "| Cantidad: " + carrito.get(producto));

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
