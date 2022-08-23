package com.artiasn.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q8 {

    public static void main(String[] args) {
        System.out.println(numberOfPairs2(new int[]{1,1}));
    }

    public static int[] numberOfPairs(int[] nums) {

        int answer1 = 0;
        int answer2 = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    nums[i] = -1;
                    nums[j] = -1;
                    answer1++;
                    break;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                answer2++;
            }
        }

        return new int[]{answer1, answer2};
    }

    public static int[] numberOfPairs2(int[] nums) {

        int answer1 = 0;
        int answer2 = 0;

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)) {
                answer1++;
                list.remove(Integer.valueOf(num));
            } else {
                list.add(num);
            }
        }
        answer2 = list.size();
        return new int[]{answer1, answer2};
    }

}
