package org.example.LabBook;

public class StringOperation {
    enum DAY{
        MONDAY,TUESDAY,WEDNESDAY;
    }
    public static void main(String[] args) {
        String s1 = new String("Hello");
//        String s2 = new String("Hello");
        String s2 = s1;

        //concatenation
        String str = "core java";
        System.out.println(str = str.concat("training"));

        System.out.println("String length: "+ str.length());

        //indexOf
        System.out.println("Index : "+ str.indexOf("r"));

        //Substring
        System.out.println("Substring is " +str.substring(4,7));

        System.out.println(s1);
        System.out.println(s2);

        //isEmpty
        String ss = "imam";
        if(ss.isEmpty()){
            System.out.println("Empty String");
        }
        else{
            System.out.println("Stirng is not empty");
        }

        //VALUEof
        String input = "TUESDAY";
        DAY day = DAY.valueOf(input);
        System.out.println(day);

        //string buffer
        StringBuffer stringBuffer = new StringBuffer("hi");
        stringBuffer.append("Hello");
        System.out.println(stringBuffer.toString());

        //reverse a string
        System.out.println(stringBuffer.reverse().toString());

        //stringbuilder
        StringBuilder stringBuilder = new StringBuilder("Ascendion"+" ");
        stringBuilder.append("engineering");
        System.out.println("New string: "+ stringBuilder.toString());




    }
}
