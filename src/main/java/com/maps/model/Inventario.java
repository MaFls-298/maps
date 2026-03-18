package com.maps.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Inventario {

    public static Map<String, String> cargarInventario(String archivo, Map<String, String> map)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("data/ListadoProducto.txt"));
        String linea;
        while ((linea = br.readLine()) !=null){
            String[] partes = linea.split("\\|");

            if (partes.length==2){
                String categoria = partes[0].trim();
                String producto = partes[1].trim();
                map.put(producto, categoria);
            }
        }

        br.close();
        return map;
    }
    
}
