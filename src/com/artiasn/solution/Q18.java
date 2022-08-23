package com.artiasn.solution;

public class Q18 {

    public static void main(String[] args) {
        System.out.println(largestLocal(new int[][]{{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}}));
//        System.out.println(largestLocal(new int[][]{{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}}));
    }

    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n-2][n-2];
        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid.length-1; j++) {
                maxLocal[i-1][j-1] = getMax(grid, i, j);
            }
        }
        return maxLocal;
    }

    public static int getMax(int[][] grid, int i, int j) {
        int max = 0;
        for (int i1 = i - 1; i1 <= i + 1; i1++) {
            for (int j1 = j - 1; j1 <= j + 1; j1++) {
                int i2 = grid[i1][j1];
                if (i2 > max) {
                    max = i2;
                }
            }
        }
        return max;
    }

}
