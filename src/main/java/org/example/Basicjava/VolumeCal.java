package org.example.Basicjava;

public class VolumeCal {
    private double length,breadth,height;
    public VolumeCal(double length,double breadth,double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }
    public void CalculateVol(){
        System.out.println("Volume calculation" + "="+(length * breadth * height));
    }

    public static void main(String[] args) {
        VolumeCal box = new VolumeCal(10,20,30);
        box.CalculateVol();
    }

//    private double length;
//    private double width;
//    private double height;
//
//    public VolumeCal(double length, double width, double height) {
//        this.length = length;
//        this.width = width;
//        this.height = height;
//    }
//    public void Calculate(){
//        double volume = length * width * height;
//        System.out.println("Volume is " + volume);
//    }
//
//    public static void main(String[] args) {
//        VolumeCal volumeCal = new VolumeCal(2.0, 3.0, 4.0);
//        volumeCal.Calculate();
//    }
}
