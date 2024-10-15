package org.example.Basicjava.polymorphism;

public class polymorphism_overriding {

    public static void main(String[] args) {
        Cheapcard obj3 = new Cheapcard();
        obj3.readCard();
    }
}

class Swipecard {
    void readCard() {
        System.out.println("readCard in superclass");
    }
}

class Cheapcard extends Swipecard {
    void readCard() {
        super.readCard();
        System.out.println("readCard in subclass");
    }
}
