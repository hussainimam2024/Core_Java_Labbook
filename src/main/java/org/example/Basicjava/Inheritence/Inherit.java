package org.example.Basicjava.Inheritence;

public class Inherit {
    public static void main(String[] args) {

        Derived obj = new Derived();
        obj.drivemethod();
    }
    static class Inherited {
        public void basemethod() {
            System.out.println("Inherit basemethod");
        }
    }
    static class Derived extends Inherited {
        public void drivemethod() {
            super.basemethod();
            System.out.println("Derived drivemethod");
        }

    }
}
