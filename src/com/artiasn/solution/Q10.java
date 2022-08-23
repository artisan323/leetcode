package com.artiasn.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Q10 {

    public static void main(String[] args) {

        System.out.println(Long.valueOf("4333639502"));
        System.out.println(smallestTrimmedNumbers(new String[]{"24","37","96","04"},
                new int[][]{{2,1},{2,2}}));
    }

    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

        Map<Integer, List<Long>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>(queries.length);
        for (int i = 0; i < queries.length; i++) {
            set.add(queries[i][1]);
        }
        for (Integer integer : set) {
            List<Long> collect = Arrays.stream(nums).map(s -> Long.valueOf(s.substring(s.length() - integer))).collect(Collectors.toList());
            map.put(integer, collect);
        }

        int[] returnArr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i][0];
            int index = queries[i][1];
            List<Long> strings = map.get(index);
//            List<Long> sortArr = new ArrayList<>(strings.size());
//            sortArr.addAll(strings);
//            sortArr.sort(Long::compareTo);
//            Long integer = sortArr.get(query - 1);
//            int insert = strings.lastIndexOf(integer);
//            int indexOf = strings.indexOf(integer);
//            if (indexOf == 0) {
//                insert = indexOf;
//            }
            returnArr[i] = searchInsert(strings.stream().toArray(Long[]::new), 0, strings.size()-1, query);
        }

        return returnArr;
    }

    public static int searchInsert(Long[] num,int low,int high,int targe){
        if (low>high ||
                num.length == 0 || targe > num[high]|| targe < num[low]) {
            return -1;
        }
        /**
         * 两个优化：1.从 （high + low）/2改为low + （high-low）/2
         * 2.改为 low+（high-low）*（index - arr[low]）/（arr[high]-arr[low]）
         */
        int mid = (int) (low+(high-low)*(targe - num[low])/(num[high]-num[low]));
        if (num[mid] > targe){
            return searchInsert(num, low, mid-1, targe);
        }else if (num[mid] < targe){
            return searchInsert(num, mid+1, high, targe);
        }else {
            return mid;
        }
    }




    // ["64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"]
    //[[9,4],[6,1],[3,8],[12,9],[11,4],[4,9],[2,7],[10,3],[13,1],[13,1],[6,1],[5,10]]

}
