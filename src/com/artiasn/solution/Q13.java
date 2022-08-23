package com.artiasn.solution;

public class Q13 {

    public static void main(String[] args) {

    }

    public static long countExcellentPairs(int[] nums, int k) {
        long result = 0;
        for (int j : nums) {
            for (int num : nums) {
                int n1 = j;
                int n2 = num;
                int n = Integer.bitCount(n1) + Integer.bitCount(n2);
                if (n > k) {
                    result++;
                }
            }
        }
        return result;
    }

}
