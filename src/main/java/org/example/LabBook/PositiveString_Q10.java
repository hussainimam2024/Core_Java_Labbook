package org.example.LabBook;

import java.util.Scanner;

/*Q10
Create a method that accepts a String and checks if it is a positive string.
A string is  considered a positive string,
if on moving from left to right each character in the String comes  after the
previous characters in the Alphabetical order. For Example: ANT is a positive String
(Since T comes after N and N comes after A). The method should return true if the entered string  is positive.
*/
public class PositiveString_Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean ans = Check_positive(str);
        System.out.println("Entered string is:"+ans);
    }
    public static boolean Check_positive(String str) {
        str = str.toUpperCase();
        for(int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            char ch1 = str.charAt(i-1);
            if(ch < ch1){
                return false;
            }
        }
        return true;
    }
}
