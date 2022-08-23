package com.artiasn.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q9 {

    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401}));
    }

    public static int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            Integer sum = sum(n);
            if (map.containsKey(sum)) {
                map.get(sum).add(i);
            } else {
                List<Integer> index = new ArrayList<>(2);
                index.add(i);
                map.put(sum, index);
            }
        }

        for (List<Integer> v : map.values()) {
            int size = v.size();
            if (size >= 2) {
                int[] numArray = new int[size];
                for (int i = 0; i < v.size(); i++) {
                    numArray[i] = nums[v.get(i)];
                }
                Arrays.sort(numArray);
                int p = numArray[size-1] + numArray[size-2];
                if (p > max) {
                    max = p;
                }
            }
        }
        return max;

    }

    public static Integer sum(int num) {
        int sum = 0;
        while(num!=0){
            sum = sum + num%10;
            num = num/10;
        }
        return sum;
    }
//[229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401]
}
