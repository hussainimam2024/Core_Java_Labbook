package org.example.Basicjava.Interface;

public class SimpleCal {
    int add(int a,int b){
        int i=10;
        return i;
    }

    class Cal extends SimpleCal {
        @Override
        int add(int a,int b){
            return a+b;
        }
    }
    public static void main(String[] args) {
        SimpleCal s=new SimpleCal();
        System.out.println(s.add(1,2));
    }
}
