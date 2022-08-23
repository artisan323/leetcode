package com.artiasn.solution;

public class Q2 {

    public static void main(String[] args) {
        int[][] s = new int[][]{{1,0},{4,25},{5,50}};
        System.out.println(s.length);

        System.out.println(calculateTax(s, 2));
    }


    public static double calculateTax(int[][] brackets, int income) {
        double p = 0;
        int preUpper = 0;

        for (int i = 0; i < brackets.length; i++) {
            int[] bracket = brackets[i];
            int upper = bracket[0];
            int percent = bracket[1];
            double pp = 0;
            if (income >= upper) {
                pp = (upper - preUpper)*percent*0.01;
            } if (income <= upper) {
                pp = (income - preUpper)*percent*0.01;
                p+=pp;
                break;
            }
            p+=pp;
            preUpper = upper;
        }
        return p;
    }

}
