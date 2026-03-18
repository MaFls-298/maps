package com.maps.factory;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class MapFactory {
    public static Map<String, String> getMap(int opcion){
        switch(opcion){
            case 1:
                return new HashMap<>();
            case 2:
                return new TreeMap<>();
            case 3:
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Opción invalida");
                

        }
    }
    
}
