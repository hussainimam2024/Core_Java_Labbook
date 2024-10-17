package org.example.LabBook3;

import org.openqa.selenium.devtools.v85.dom.model.ShapeOutsideInfo;

import java.util.Arrays;
import java.util.Scanner;

public class SortNames_Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter the size of the array");
        int n = sc.nextInt();
        String[] names = new String[n];
        System.out.println("Enter the product names of the array: ");
        for(int i = 0; i <n; i++){
            names[i] = sc.next();
        }
        sc.close();
        Arrays.sort(names);
        System.out.println("sorted strings available in string:");
        for(String name : names){
            System.out.println(name);
        }

    }
}
