package org.example.Basicjava;

public class ConstructorsEx {
    int x;
    int y;

    ConstructorsEx(int a, int b) {
        this.x = b;
        this.y = b;

    }
    public void add(){
        System.out.println("Addition"+(x+y));
    }
}
