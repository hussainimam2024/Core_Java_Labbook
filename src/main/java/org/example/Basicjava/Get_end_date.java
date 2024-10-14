package org.example.Basicjava;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

class get_end_date {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2024, Month.SEPTEMBER, 25);
        int duration = 50;
        int fullWeeks = duration / 5;
        int remainingdays = duration % 5;
        LocalDate end = start.plusWeeks(fullWeeks);
        for (int i = 0; i < remainingdays; i++) {
            end = end.plusDays(1);
            if (end.getDayOfWeek() == DayOfWeek.SATURDAY) {
                end = end.plusDays(2);
            }
        }
        System.out.println("Training end date is : " + end);
    }
}



//package org.example.Basicjava;

//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.time.Month;
//
//public class Get_end_date {
//    public static void main(String[] args) {
//        Cal_date obj1 = new Cal_date();
//        obj1.end_date();
//    }
//
//    public static class Cal_date {
//        LocalDate start = LocalDate.of(2024, Month.SEPTEMBER, 25); // Training start date
//        int duration = 50;
//        public void end_date() {
//            LocalDate end = start;
//            long leftdays = duration;
//            while (leftdays > 0) {
//                end = end.plusDays(1);
//
//                if (end.getDayOfWeek() != DayOfWeek.SATURDAY && end.getDayOfWeek() != DayOfWeek.SUNDAY) {
//                    leftdays--;
//                }
//            }
//            System.out.println("Training end date excluding weekends: " + end);
//        }
//    }
//}


