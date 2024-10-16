package org.example.Basicjava.ExceptionHandling;

public class checkException {
    public static void main(String[] args) {
        //NullPointerException
        try {
            String str = null;
            str.equals("hello");
        } catch (NullPointerException e1) {
            System.out.println("NullPointerException: " + e1.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        //handle both ArithmeticException and NullPointerException
        try {
            int a = 0;
            int b = 30 / a;
            String str1 = null;
            System.out.println(str1.concat("a"));
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        } catch (NullPointerException e1) {
            System.out.println("NullPointerException: " + e1.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
