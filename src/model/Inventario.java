package model;

import java.io.*;
import java.util.*;

public class Inventario {

    public static Map<String, String> cargarInventario(String archivo, Map<String, String> map){
        BufferedReader br = new BufferedReader(new FileReader("data/ListadoProducto.txt"));
        String linea;
        while ((linea = br.readLine()) !=null){
            String[] partes = linea.split("\\|");

            if (partes.length==2){
                String categoria = partes[0];
                String producto = partes[1];
                map.put(producto, categoria);
            }
        }

        br.close();
        return map;
    }
    
}
