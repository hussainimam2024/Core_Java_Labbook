package org.example.Basicjava.ExceptionHandling;

public class CustomException {
    public static class ImamException extends RuntimeException{
        public ImamException(String message){
            super(message);
        }
    }
    public static void main(String[] args) {
        int i=10;
        int j=0;
        try{
            j = 18/i;
            if(j==0){
                throw new ImamException("cannot divide by i");
            }
        }
        catch (ImamException e) {
            System.out.println("this is default output" + e);
        } catch (Exception e) {
            System.out.println("something is wrong");
        }
    }
}
