package com.artiasn.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q17 {

    public static void main(String[] args) {
        System.out.println(validPartition2(new int[]{4,4,4,5,6,7}));
    }

    public static boolean validPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        Arrays.sort(nums);
        System.out.println(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (!check(nums[i], nums[i+1], nums[i+2])) {
                return false;
            }
        }
        return true;
    }

    public static boolean validPartition2(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        List<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> arr = getArr(s);
        List<List<Integer>> collect = arr.stream()
                .distinct()
                .filter(list -> list.size() == 2 || list.size() == 3)
                .filter(list -> {
                    if (list.size() == 2) {
                        return list.get(0).equals(list.get(1));
                    }
                    return check(list.get(0), list.get(1), list.get(2));
                })
                .collect(Collectors.toList());
        System.out.println(collect);
        if (collect.isEmpty()) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {

        }

        return true;
    }

    public static List<List<Integer>> getArr(List<Integer> list) {
        if(list.size()>0){
            List<List<Integer>> result = new ArrayList<>();
            long n = (long) Math.pow(2, list.size());
            List<Integer> temp;
            for (long l = 0L; l < n; l++) {
                temp = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    if ((l >>> i & 1) == 1) {
                        temp.add(list.get(i));
                    }
                }
                if (!temp.isEmpty()) {
                    result.add(temp);
                }
            }
            return result;
        }
        return null;
    }



    public static boolean check(int n1, int n2, int n3) {
        if (n1 == n2 && n2 == n3) {
            return true;
        }
        return n2 - n1 == n3 - n2 && n3 - n2 == 1 && n2 - n1 == 1;
    }
    public static boolean check(int n1, int n2) {
        return n1 == n2;
    }


}
