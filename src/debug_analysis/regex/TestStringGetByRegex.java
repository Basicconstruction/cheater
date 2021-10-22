package debug_analysis.regex;

import regex.StringGetByRegex;

public class TestStringGetByRegex {
    public static void main(String[] args){
        String s = "public class TestStringGetByRegex ";
        String regex = "c class {} ";
        System.out.println(new StringGetByRegex().getThatOne(s,regex));
        s = "public class    ";
        regex = "c class {}";
        System.out.println(new StringGetByRegex().getThatOne(s,regex).length());
    }
}
