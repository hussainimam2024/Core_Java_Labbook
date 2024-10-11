package org.example.LabBook;

import java.util.Scanner;
/*Q2- Write a program to accept a number from user as a command line
 argument and check  whether the given number is positive or negative number.
*/

public class PersonMain_Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num >= 0) {
            System.out.println("Number is postive");
        }
        else{
            System.out.println("Number is negative");
        }
    }

}
