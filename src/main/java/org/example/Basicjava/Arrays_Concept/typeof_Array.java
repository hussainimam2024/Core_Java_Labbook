package org.example.Basicjava.Arrays_Concept;

public class typeof_Array {
    public static void main(String[] args) {
        int num[] = new int[5];
        num[0] = 100;
        num[1] = 200;
        num[2] = 300;
        num[3] = 400;
        num[4] = 500;
        System.out.println("One-dimensional array values:");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();


        int a[][] = new int[5][5];
        a[0][0] = 100;
        a[0][1] = 200;
        a[0][2] = 300;
        a[0][3] = 400;
        a[0][4] = 500;
        for (int i = 0; i < 1; i++) {
        for (int j = 0; j < 5; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
