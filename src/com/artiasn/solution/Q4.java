package com.artiasn.solution;

import java.util.ArrayList;
import java.util.List;

public class Q4 {

    public static void main(String[] args) {
        System.out.println(minimumNumbers(1, 1));
    }

    public static int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        for (int i = 1; i <= num; i++) {
            if ((num - i*k) >= 0 && (num - i*k) % 10 == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int minimumNumbersV2(int num, int k) {

        if (num == 0) {
            return 0;
        }

        int max = num * 2;
        List<Integer> integers = new ArrayList<>();
        int tmp = k;
        while (tmp < max) {
            integers.add(tmp);
            tmp += 10;
        }
        List<List<Integer>> arr = getArr(integers);

        if (arr == null) {
            return -1;
        }

        int minSize = Integer.MAX_VALUE;
        for (List<Integer> integerList : arr) {
            int sum = integerList.stream().mapToInt(Integer::intValue).sum();
            if (sum == num) {
                minSize = Math.min(minSize, integerList.size());
            }
            if (integerList.size() == 1) {
                int j = integerList.get(0);
                if (j == 0) {
                    continue;
                }
                int p = j;
                int s = 0;
                while (p < num) {
                    p = p + j;
                    s++;
                }
                if (p == num) {
                    minSize = Math.min(minSize, s+1);
                }
            }
        }

        if (minSize > 3000) {
            return -1;
        }

        return minSize;
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
}
