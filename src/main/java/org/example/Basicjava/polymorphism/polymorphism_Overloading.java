package org.example.Basicjava.polymorphism;
//method overloading means method having the same name but different parametes
public class polymorphism_Overloading {
    polymorphism_Overloading(){
        System.out.println("polymorphism_Ex");
    }
    polymorphism_Overloading(int a){
        System.out.println("polymorphism_Ex: " + a);
    }
    polymorphism_Overloading(int a, int b){
        int c = a *b;
        System.out.println("polymorphism_Ex in multiplication: " +c);
    }

    public static void main(String[] args) {
        polymorphism_Overloading obj = new polymorphism_Overloading();
        polymorphism_Overloading obj2 = new polymorphism_Overloading(5000);
        polymorphism_Overloading obj3 = new polymorphism_Overloading(4,5);
    }
}
