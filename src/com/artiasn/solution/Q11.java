package com.artiasn.solution;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Q11 {

    public static void main(String[] args) {
        System.out.println(repeatedCharacter3("abcdd"));
    }

    public static char repeatedCharacter3(String s) {
        Set<Character> set = new LinkedHashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character aChar = chars[i];
            if (set.contains(aChar)) {
                return aChar;
            } else {
                set.add(aChar);
            }
        }
        char a = 'a';
        return a;
    }

    public static char repeatedCharacter(String s) {
        Set<Integer> set = new LinkedHashSet<>();
        int length = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                if (chars[i] == chars[j]) {
                    Integer a = (int) chars[i];
                    if (!set.contains(a)) {
                        set.add(a);
                    } else {
                        set.remove(a);
                    }
                }
            }
        }
        char a = 'a';
        return a;
    }

    public static char repeatedCharacter2(String s) {
        char[] chars = s.toCharArray();
        int[] a = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            int n = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    n++;
                }
            }
            a[i] = n;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 2) {
                return chars[i];
            }
        }
        return 'n';
    }

}
