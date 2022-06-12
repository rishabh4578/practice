package org.example.Practice;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/edit-distance-dp-5/
 * https://www.youtube.com/watch?v=AuYujVj646Q
 */
public class MinimumEditDistance {

    public static void main(String[] args) {
        System.out.println(minEditDistance("sunday", "saturday"));
    }

    public static int minEditDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        //dp arr
        int[][] dp = new int[m + 1][];
        for (int i = 0; i <= m; i++) {
            dp[i] = new int[n + 1];
            Arrays.fill(dp[i], -1);
        }

        return medInternal(s1, s2, m, n, dp);
    }

    private static int medInternal(String s1, String s2, int m, int n, int[][] dp) {
        //if no chars remain to be transformed in one or both strings, return the remaining length of
        //the other string as all inserts would be required
        if (m == 0 || n == 0) return (m == 0) ? n : m; //both might be zero, still return 0

        if (dp[m][n] != -1) return dp[m][n];

        //if chars are same, no cost of transforming chars at this position
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return dp[m][n] = medInternal(s1, s2, m - 1, n - 1, dp);    //set value and return the value

        //return min cost by trying all possible operations
        int insertCost = 1 + medInternal(s1, s2, m, n - 1, dp);
        int removeCost = 1 + medInternal(s1, s2, m - 1, n, dp);
        int replaceCost = 1 + medInternal(s1, s2, m - 1, n - 1, dp);
        int minCost = min(insertCost, removeCost, replaceCost);
        return dp[m][n] = minCost;
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
