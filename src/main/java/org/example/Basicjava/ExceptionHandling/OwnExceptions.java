package org.example.Basicjava.ExceptionHandling;

import java.io.FileNotFoundException;

public class OwnExceptions {
    static class Own_Exceptions{
        void proc(){
            try{
                throw new FileNotFoundException("From Exception");
            } catch (FileNotFoundException e) {
                System.out.println("From Exception inside demo");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Own_Exceptions obj = new Own_Exceptions();
        obj.proc();

    }

}

