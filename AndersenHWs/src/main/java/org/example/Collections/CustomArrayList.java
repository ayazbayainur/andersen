package org.example.Collections;

import java.util.Arrays;

public class CustomArrayList<T> {
    private static final int INITIAL_CAPACITY = 10;
    private int size;
    private Object[] arr;

    public CustomArrayList(){
        this.arr = new Object[INITIAL_CAPACITY];
    }
    public CustomArrayList(int n){
        this.arr = new Object[n];
    }

    public void put(T obj){
        if(size == arr.length){
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[size++] = obj;
    }

    public void putAtSpecificIndex(int ind, T obj){
        try {
            int j = 0;
            Object[] temp = new Object[arr.length * 2];
            for (int i = 0; i < size + 1; i++) {
                if (i == ind) {
                    temp[i] = obj;
                    continue;
                }
                temp[i] = arr[j];
                j++;
            }
            arr = temp;
            size++;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public T getByIndex(int i){
        Object obj = null;
        try{
            obj = arr[i];
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return (T) obj;
    }

    public void deleteByIndex(int ind){
        try {
            size--;
            if (size <= arr.length / 2) {
                Object[] temp = new Object[arr.length / 2];
                int k = 0;

                for (int j = 0; j < size + 1; j++) {
                    if (j == ind) {
                        continue;
                    }
                    temp[k] = arr[j];
                    k++;
                }
                arr = temp;
            }
        } catch(Exception ex){
        System.out.println(ex.getMessage());
    }
    }

    public int size(){
        return size;
    }

    public void printCustomArrayList(){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
