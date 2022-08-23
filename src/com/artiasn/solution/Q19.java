package com.artiasn.solution;

public class Q19 {

    public static void main(String[] args) {

    }


    public static String smallestNumber(String pattern) {
        int[] dp = new int[pattern.length()+1];
        dp[0] = 1;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I') {
                dp[i+1] = dp[i] + 1;
            } else {

            }
        }

        return "";
    }

    public static int getMin(int[] nums, int n) {
        while (n > 0) {
            for (int num : nums) {
                if (num == n) {
                    n--;
                    break;
                }
            }
        }
        return n;
    }

}
