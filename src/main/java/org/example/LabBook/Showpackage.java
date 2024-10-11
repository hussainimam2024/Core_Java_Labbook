package org.example.LabBook;

import org.example.Basicjava.ClassExample;
import org.example.Basicjava.VolumeCal;

import static java.lang.Math.sqrt;

public class Showpackage {
    public static void main(String[] args) {
        //to show how to import package
        VolumeCal box = new VolumeCal(10,20,30);
        box.CalculateVol();
        ClassExample example = new ClassExample();
        example.Volume();
        System.out.println("square root"+sqrt(9));
    }
}
