package com.artiasn.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q {

    public static void main(String[] args) {

        int[] s = new int[]{8,15,10,20,8};
        System.out.println(distributeCookies2(s, 2));
    }


    public static int distributeCookiesV3(int[] cookies, int k) {

        int sum = Arrays.stream(cookies).sum();
        if (sum%2 != 0) {
            sum++;
        }
        int ideal = sum/k;
        List<Integer> s = Arrays.stream(cookies).boxed().collect(Collectors.toList());
        List<List<Integer>> arr = getArr(s);

        return 1;

    }


    public static int distributeCookies(int[] cookies, int k) {
        int sum = Arrays.stream(cookies).sum();
        if (sum%2 != 0) {
            sum++;
        }
        int ideal = sum/k;

        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < cookies.length; i++) {
            for (int j = 0; j < cookies.length; j++) {
                if (index.contains(i) || index.contains(j) || i == j) {
                    continue;
                }
                if (cookies[i] + cookies[j] == ideal) {
                    if (!index.contains(i)) {
                        index.add(i);
                    }
                    if (!index.contains(i)) {
                        index.add(j);
                    }
                }
            }
        }
        return ideal;

    }

    public static int distributeCookies2(int[] cookies, int k) {
        int sum = Arrays.stream(cookies).sum();
        if (sum%2 != 0) {
            sum++;
        }
        int ideal = sum/k;
        List<Integer> s = Arrays.stream(cookies).boxed().collect(Collectors.toList());
        List<List<Integer>> arr = getArr(s);
        List<List<Integer>> back = back(arr, ideal);
        System.out.println(back);
        System.out.println(arr);
        int a = ideal;
        int preMin = ideal;
        for (List<Integer> integers : arr) {
            int sum2 = 0;
            for (Integer integer : integers) {
                sum2 += integer;
            }
            if (sum2 > ideal) {
                a = Math.min(preMin, sum2);
                preMin = sum2;
            }
        }
        return a;
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

    public static List<List<Integer>> back(List<List<Integer>> list,Integer x){
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> objects = new ArrayList<Integer>();
        Integer sum=new Integer(0);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> integers = list.get(i);
            for (int i1 = 0; i1 < integers.size(); i1++) {
                sum+=integers.get(i1);
                objects.add(Math.abs(sum-x));
            }
            sum=0;
        }
        Integer min = Collections.min(objects);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> integers = list.get(i);
            for (int i1 = 0; i1 < integers.size(); i1++) {
                sum+=integers.get(i1);
            }
            if(min==Math.abs(sum-x)){
                lists.add(integers);
            }
            sum=0;
        }
        return lists;
    }


}
