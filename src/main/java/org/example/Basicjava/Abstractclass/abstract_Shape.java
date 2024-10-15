package org.example.Basicjava.Abstractclass;

// Abstract class Shape
abstract class abstract_Shape {

    abstract void draw();
    static class Triangle extends abstract_Shape {
        void draw() {
            System.out.println("Drawing a triangle.");
        }
    }
    static class Circle extends abstract_Shape {

        void draw() {
            System.out.println("Drawing a circle.");
        }
    }
    public static void main(String[] args) {
        abstract_Shape shape1 = new Triangle();
        abstract_Shape shape2 = new Circle();
        shape1.draw();
        shape2.draw();
    }
}
