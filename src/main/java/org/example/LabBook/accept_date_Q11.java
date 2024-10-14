package org.example.LabBook;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
/*Q11
Create a program to accept date and print the duration in days, months and years
with  regards to current system date.

 */
public class accept_date_Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date YYYY-MM-DD");
        String inputdate = sc.nextLine();
        LocalDate today = LocalDate.now();

        LocalDate date = LocalDate.parse(inputdate);
        Period period = Period.between(date, today);
        System.out.println("Duration: " + period.getYears() + " years, "
                + period.getMonths() + " months, and "
                + period.getDays() + " days.");



    }
}
