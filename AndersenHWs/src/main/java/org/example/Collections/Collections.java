package org.example.Collections;

public class Collections {

    public static void main(String[] args){
        CustomArrayList<Integer> arrayList = new CustomArrayList<>();
        CustomArrayList<String> arrayList1 = new CustomArrayList(5);
        for(int i = 0; i <= 10; i++){
            arrayList.put(i);
        }
        arrayList.printCustomArrayList();
        arrayList.deleteByIndex(5);
        System.out.println(arrayList.size());
        arrayList.printCustomArrayList();
        arrayList.getByIndex(-6);
        arrayList.putAtSpecificIndex(3, 2);
        arrayList.printCustomArrayList();
        System.out.println(arrayList.size());
        System.out.println();
        arrayList1.printCustomArrayList();
        arrayList1.put("first");
        arrayList1.put("second");
        arrayList1.getByIndex(6);
        arrayList1.deleteByIndex(9);
        System.out.println(arrayList1.size());
        arrayList1.printCustomArrayList();

        CustomHashSet<Integer> customHashSet = new CustomHashSet<>();
        customHashSet.put(2);
        customHashSet.put(2);
        customHashSet.put(3);
        customHashSet.put(4);
        customHashSet.delete(2);
        System.out.println(customHashSet.size());
        customHashSet.iterate();
    }
}
