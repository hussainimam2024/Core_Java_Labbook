package org.example.Basicjava.Collections_Ex;

import java.util.*;

public class Set_Ex {
    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<Integer>();
        s1.add(100);
        s1.add(1000);
        s1.add(10000);
        s1.add(100);
        s1.add(10000);
        s1.add(1000);
        System.out.println("size:" + s1.size());
        for (Integer index : s1) {
            System.out.println(index + "");
        }
        System.out.println();

        HashSet<String> s2 = new HashSet<>();
        s2.add("Banana");
        s2.add("Apple");
        s2.add("grapes");
        for(String index1 : s2){
            System.out.println(index1 + "");
        }
        System.out.println();

        LinkedHashSet<String> s3 = new LinkedHashSet<>();
        s3.add("India");
        s3.add("America");
        s3.add("Canada");
        for(String index2 : s3){
            System.out.println(index2 + "");
        }
        System.out.println();

        TreeSet<String> s4 = new TreeSet<>();
        s4.add("India");
        s4.add("America");
        s4.add("Canada");
        Iterator<String> iterator = s4.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
