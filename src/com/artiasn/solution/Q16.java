package com.artiasn.solution;

public class Q16 {

    public static void main(String[] args) {
        System.out.println(arithmeticTriplets(new int[]{4,5,6,7,8,9}, 2));
    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        int n = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            for (int j = nums.length-1; j >= 0; j--) {
                if (nums[i] - nums[j] == diff) {
                    for (int p = j; p >= 0; p--) {
                        if (nums[j] - nums[p] == diff) {
                            n++;
                        }
                    }
                }
            }
        }
        return n;
    }

}
