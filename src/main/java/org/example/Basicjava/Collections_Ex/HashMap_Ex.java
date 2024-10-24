package org.example.Basicjava.Collections_Ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap_Ex {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println("Key: " + e.getKey()+" Value: " + e.getValue());
        }
        System.out.println();
        // Using keySet()
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
        System.out.println();

        // Using map.values()
        for (String value : map.values()) {
            System.out.println("Value: " + value);
        }
    }
}
