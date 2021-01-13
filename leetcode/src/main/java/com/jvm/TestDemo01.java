package com.jvm;

public class TestDemo01 {
    public static void main(String[] args) {
        String str1 = new StringBuilder("ceshi").append("ceshi2").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        String str3 = "ceshiceshi2";
        System.out.println(str3.intern() == str3);

        String str4 = new StringBuilder("ceshi").append("ceshi2").toString();
        System.out.println(str4.intern() == str4);

        String str5 = "java";
        System.out.println(str5.intern() == str5);

    }
}
