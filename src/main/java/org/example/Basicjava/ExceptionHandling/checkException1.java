package org.example.Basicjava.ExceptionHandling;

public class checkException1 {
    public static void main(String[] args) {
//output of execution depends on order of statments written inside the try and catch
        int num[] = {1,2,3,4,5};
        try{
            int res = 10/0;
            System.out.println("access index:"+ num[4]);
            System.out.println("length of array:"+num.length);
            String s = null;
            System.out.println("length of string:"+s.length());
        }
        catch (ArithmeticException e){
            System.out.println("Arithmetic Exception" + e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException"+ e.getMessage());
        }
        catch(Exception e){
            System.out.println("Unchecked exception"+e.getMessage());
        }
        finally {
            System.out.println("finally block");
        }
    }
}
