package com.artiasn.solution;

public class Q12 {

    public static void main(String[] args) {
        int[][] s = new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(equalPairs(s));
    }



    public static int equalPairs(int[][] grid) {
        int n = 0;
        int length = grid.length;
        int[][] cGrid = new int[length][];
        for (int i = 0; i < grid.length; i++) {
            int[] t = new int[length];
            for (int j = 0; j < grid.length; j++) {
                t[j] = grid[j][i];
            }
            cGrid[i] = t;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < cGrid.length; j++) {
                int[] tG = grid[i];
                int[] tC = cGrid[j];
                int tmp  = 0;
                for (int b = 0; b < length; b++){
                    if (tG[b] == tC[b]) {
                        tmp++;
                    }
                }
                if (tmp == length) {
                    n++;
                }
            }
        }
        return n;
    }
}
