package org.example.Basicjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pattern_Ex {
    public static void main(String[] args) {
        String str = "hi";
        String str2 = "hello";
        boolean pattermatch = Pattern.matches(str, str2);
        System.out.println("pattern match is:"+pattermatch);

        String input = "Shop,Mop,Hopping,Chopping";
        Pattern p1 = Pattern.compile("Mop");
        Matcher m1 = p1.matcher(input);
        System.out.println(m1.matches());

        while (m1.find()) {
            System.out.println(m1.group() + ":" + m1.start()+ ":" + m1.end());
        }
        String input1 = "Exo1&";
        Pattern p2 = Pattern.compile("^[A-Z].*[0-9]&");
        Matcher m2 = p2.matcher(input1);
        System.out.println(m2.matches());
        if(m2.find()){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }

       //checking email addreess
        String input3 = "Exo1&";
        String input4 = "examplegmail.com";
        Pattern p = Pattern.compile("^[A-Z].*[0-9]&");
        Matcher m = p2.matcher(input3);
        Pattern gmailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@gmail\\.com$");
        Matcher gmailMatcher = gmailPattern.matcher(input4);
        System.out.println(m.matches());
        if(m2.matches()) {
            System.out.println("Pattern 1 matches: true");
        } else {
            System.out.println("Pattern 1 matches: false");
        }

        System.out.println(gmailMatcher.matches());
        if(gmailMatcher.matches()) {
            System.out.println("Valid Gmail: true");
        } else {
            System.out.println("Valid Gmail: false");
        }

        String email = "imam.hussain@gmail.com";
        Pattern pt = Pattern.compile("^[\\w._]+@[\\w]+\\.[\\w.]{3,6}&");
        Matcher mch = pt.matcher(email);
        if(mch.matches()) {
            System.out.println("email.found");
            System.out.println(mch.group()+":" + mch.start()+ ":" + mch.end());
        }
        else{
            System.out.println("email not found");
            System.out.println(mch.group()+":" + mch.start()+ ":" + mch.end());
        }




        //check valid mobile number

        String mobile = "987654322";
        Pattern mobilePattern = Pattern.compile("^[789]\\d{9}$");
        Matcher mobileMatcher = mobilePattern.matcher(mobile);

        if(mobileMatcher.matches()) {
            System.out.println("Valid Indian mobile number: true");
        } else {
            System.out.println("Valid Indian mobile number: false");
        }

        //white space pattern
        String s = "Welcome Imam";
        Pattern p3 = Pattern.compile("\\s");
        Matcher m3 = p3.matcher(s);
        System.out.println(m3.matches());

        while(m3.find()) {
            System.out.println(m3.group()  + m3.start()+ " white space " + m3.end());
        }

        String ss = "Welcome Imam";
        Pattern p33 = Pattern.compile("^Welcome$");
        Matcher m33 = p3.matcher(ss);
        System.out.println(m3.matches());

        while(m33.find()) {
            System.out.println(m3.group()  + m3.start()+  + m3.end());
        }



    }

}
