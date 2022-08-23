package com.artiasn.solution;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1 {


    public static void main(String[] args) {
        int[] s = new int[]{35, 48};
        System.out.println(maxConsecutive(28, 50, s));
    }

    public static int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int bottomCount = special[0] - bottom;
        int topCount = top - special[special.length-1];
        int maxCount = Math.max(bottomCount, topCount);
        for (int i = 1; i < special.length; i++) {
            int diff = special[i] - special[i-1] - 1;
            if (diff > maxCount) {
                maxCount = diff;
            }
        }
        return maxCount;
    }

}


