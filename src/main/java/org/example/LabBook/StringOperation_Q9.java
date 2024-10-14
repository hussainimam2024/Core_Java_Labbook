package org.example.LabBook;

import java.util.HashSet;
import java.util.Scanner;

public class StringOperation_Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a string: ");
        String str = sc.nextLine();

        System.out.println("following are the operation:");

        System.out.println("write 1 or 2 or 3 or 4 in terminal");
        System.out.println("1->Add the string to itself");
        System.out.println("2->Replace odd positions with #");
        System.out.println("3->Remove duplicate characters in the string");
        System.out.println("4->Change odd characters to upper case");

        int choice = sc.nextInt();
        String result = Operations(str, choice);
        System.out.println("Result: " + result);
    }
    private static String Operations(String input, int choice) {
        switch (choice) {
            case 1: return input +" "+ input;
            case 2: return replaceOdd(input);
            case 3: return removeDup(input);
            case 4: return changeOTC(input);
            default: return "Invalid choice";
        }
    }
    private static String replaceOdd(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(i % 2 != 0 ? '#' : str.charAt(i));
        }
        return sb.toString();
    }
    private static String removeDup(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.add(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    private static String changeOTC(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(i % 2 != 0 ? Character.toUpperCase(str.charAt(i)) : str.charAt(i));
        }
        return sb.toString();
    }
}
