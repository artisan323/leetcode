package com.artiasn.solution;

import java.util.ArrayList;
import java.util.List;

public class Q3 {

    public static void main(String[] args) {
        System.out.println(greatestLetter("arRAzFif"));
    }


    public static String greatestLetter(String s) {

        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[i] - 32 == chars[j]) {
                    list.add(chars[i]);
                }
            }
        }

        if (list.size() < 1) {
            return "";
        }

        char max = 65;
        for (Character character : list) {
            if (character.charValue() > max) {
                max = character.charValue();
            }
        }

        if (max > 96) {
            max -= 32;
        }

        return max + "";
    }

}
