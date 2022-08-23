package com.artiasn.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Q7 {

    public static void main(String[] args) {
        System.out.println(fillCups(new int[]{1,4,2}));
    }

    public static int fillCups(int[] amount) {
        int s = 0;
        while (true) {
            Arrays.sort(amount);
            if (amount[2] >= 1) {
                amount[2]--;
            } else if (amount[2] == 0) {
                break;
            }
            if (amount[1] >= 1) {
                amount[1]--;
            }
            s++;
        }
        return s;
    }

    public static int has(int[] amount) {
        int j = 0;
        int max = 0;
        for (int i = 0; i < amount.length; i++) {
            if (amount[i] > max) {
                j = i;
                max = amount[i];
            }
        }
        return j;
    }

}
