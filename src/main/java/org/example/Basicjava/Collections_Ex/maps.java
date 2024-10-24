package org.example.Basicjava.Collections_Ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class maps {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("1001", "Keerthi");
        hm.put("1002", "Deepa");
        hm.put("1005", "Rekha");

        for(Map.Entry<String, String> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

//        hm.put("1003", "Arun");
//        hm.put("1004", "Leena");
//
//        System.out.println(hm.get("1003"));
//
//        System.out.println(hm.values());
//        Set s1 = hm.entrySet();
//        Iterator i = s1.iterator();
//        while (i.hasNext()) {
//            Map.Entry me = (Map.Entry) i.next();
//            System.out.println(me.getKey() + ":" + me.getValue());
//        }
    }
}
