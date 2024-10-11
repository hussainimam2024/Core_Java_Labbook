package org.example.LabBook;

import java.util.HashSet;
import java.util.Scanner;

public class StringOperation_Q9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a string: ");
        String str = sc.nextLine();

        System.out.println("Choose an operation:");
        System.out.println("1: Add the String to itself");
        System.out.println("2: Replace odd positions with #");
        System.out.println("3: Remove duplicate characters");
        System.out.println("4: Change odd characters to upper case");
        int choice = sc.nextInt();

        String result = performOperation(str, choice);
        System.out.println("Result: " + result);
    }

    private static String performOperation(String input, int choice) {
        switch (choice) {
            case 1: return input + input; // Add string to itself
            case 2: return replaceOddPositions(input);
            case 3: return removeDuplicates(input);
            case 4: return changeOddToUpperCase(input);
            default: return "Invalid choice";
        }
    }

    private static String replaceOddPositions(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(i % 2 != 0 ? '#' : str.charAt(i));
        }
        return sb.toString();
    }

    private static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> charSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (charSet.add(c)) sb.append(c);
        }
        return sb.toString();
    }

    private static String changeOddToUpperCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(i % 2 != 0 ? Character.toUpperCase(str.charAt(i)) : str.charAt(i));
        }
        return sb.toString();
    }
}
