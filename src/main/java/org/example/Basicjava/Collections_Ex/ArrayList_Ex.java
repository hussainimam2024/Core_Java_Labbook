package org.example.Basicjava.Collections_Ex;

import java.util.ArrayList;

public class ArrayList_Ex {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add("Apple");
        list.add("orange");
        System.out.println("Size:" + list.size());
        System.out.println(list.contains("Hello"));
        System.out.println(list.get(2));
        System.out.println(list.remove(3));
        System.out.println("Size:" + list.size());
        System.out.println("Size:" + list);
        System.out.println(list.removeAll(list));
        System.out.println("Size:" + list.size());
        System.out.println("Size:" + list);
    }
}
