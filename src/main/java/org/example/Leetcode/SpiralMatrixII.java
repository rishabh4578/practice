package org.example.Leetcode;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/submissions/
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][];
        for (int i = 0; i < n; i++) {
            mat[i] = new int[n];
        }

        int rlu = 0;
        int rld = n - 1;
        int cll = 0;
        int clr = n - 1;

        char[] dir = {'r', 'd', 'l', 'u'}; //direction

        int v = 1;
        int r = 0;
        int c = -1;
        while (v <= (int) Math.pow(n, 2)) {
            for (char d : dir) {
                switch (d) {
                    case 'r':
                        while (c + 1 <= clr)
                            mat[r][++c] = v++;
                        rlu++;
                        break;
                    case 'd':
                        while (r + 1 <= rld)
                            mat[++r][c] = v++;
                        clr--;
                        break;
                    case 'l':
                        while (c - 1 >= cll)
                            mat[r][--c] = v++;
                        rld--;
                        break;
                    case 'u':
                        while (r - 1 >= rlu)
                            mat[--r][c] = v++;
                        cll++;
                        break;
                }
            }
        }
        return mat;
    }
}
