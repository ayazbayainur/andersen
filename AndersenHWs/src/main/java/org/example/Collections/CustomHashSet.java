package org.example.Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomHashSet<T> {
    private static final int INITIAL_CAPACITY = 16;
    private int size;
    private HashMap<T, Object> map;

    public CustomHashSet(){
        map  = new HashMap<>();
    }
    public CustomHashSet(int n){
        map = new HashMap<>(n);
    }
    public CustomHashSet(int n, float loadFactor){
        map = new HashMap<>(n, loadFactor);
    }

    public void put(T obj){
        if(!map.containsKey(obj)){
            map.put(obj, null);
            size++;
        }
    }

    public Boolean contains(T obj){
        return map.containsKey(obj);
    }

    public void iterate(){
        for(Map.Entry<T, Object> entry: map.entrySet()){
            System.out.print(entry.getKey() + " ");
        }
    }

    public void delete(T obj){
        map.remove(obj);
        size--;
    }

    public int size(){
        return size;
    }

}
