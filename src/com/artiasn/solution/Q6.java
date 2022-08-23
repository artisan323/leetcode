package com.artiasn.solution;

public class Q6 {

    public static void main(String[] args) {
        int[][] s = new int[][]{{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};
        System.out.println(checkXMatrix(s));
    }

    public static boolean checkXMatrix(int[][] grid) {
        int length = grid.length;

        if (grid[0][0] == 0 || grid[0][length-1] == 0 || grid[length-1][0] == 0 || grid[length-1][length-1] == 0) {
            return false;
        }

        for (int i = 0, j = 0, n = 0; n < length * 2; n++) {
            if (grid[i][j+1] * grid[j][i+1] != 0) {
                return false;
            }
            if (i < length) {
                i++;
                j++;
            } else {
                i--;
                j--;
            }
        }

        return false;
    }
}
