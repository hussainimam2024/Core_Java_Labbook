package org.example.Basicjava.Arrays_Concept;

class Array_Example {
    int numbers[];
    Array_Example(int i) {
        numbers = new int[i];
    }
    void populatearray() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
    }
    void displaycontents() {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Number " + i + ": " + numbers[i]);
        }
    }
    public static void main(String[] args) {
        Array_Example obj = new Array_Example(5);
        obj.populatearray();
        obj.displaycontents();
    }
}
