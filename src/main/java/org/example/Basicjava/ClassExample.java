package org.example.Basicjava;

import static java.lang.Math.sqrt;

public class ClassExample {
    static double length=10;
    static double width=20;
    static double height=40;

    public static double Volume() {

        double v = length * width * height;
        System.out.println("Volume is " + v);
        return v;
    }

    public static void main(String[] args) {
        ClassExample example = new ClassExample();
        example.Volume();
        System.out.println("square root of 9 is"+ sqrt(9));
    }
}
