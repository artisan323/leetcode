package com.artiasn.solution;

import java.util.Arrays;

public class Q14 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,0,3,5};
        System.out.println(minimumOperations(nums));
    }

    public static int minimumOperations(int[] nums) {
        int length = nums.length;
        if (length <= 0) {
            return 0;
        }
        int n = 0;
        while (!isZero(nums)) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    int tmp = nums[i];
                    n++;
                    for (int j = 0; j < length; j++) {
                        nums[j] = nums[j] - tmp;
                    }
                    break;
                }
            }
        }
        return n;
    }

    private static boolean isZero(int[] nums) {
        for (int num : nums) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }
}
