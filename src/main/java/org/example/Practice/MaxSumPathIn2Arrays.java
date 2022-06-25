package org.example.Practice;

/**
 * https://practice.geeksforgeeks.org/problems/max-sum-path-in-two-arrays/1
 * asked in Amazon
 */
public class MaxSumPathIn2Arrays {
    int maxPathSum(int ar1[], int ar2[]) {
        // Your code here
        int l1 = ar1.length;
        int l2 = ar2.length;

        int p1 = 0;
        int p2 = 0;

        int maxSum = 0;
        int sum1 = 0;
        int sum2 = 0;

        while (true) {
            if (p1 == l1 || p2 == l2)
                break;
            if (ar1[p1] < ar2[p2]) {
                sum1 += ar1[p1++];
            } else if (ar2[p2] < ar1[p1]) {
                sum2 += ar2[p2++];
            } else {//both are equal => intersection point
                maxSum += Math.max(sum1, sum2) + ar1[p1];
                sum1 = 0;
                sum2 = 0;
                p1++;
                p2++;
            }
        }
        if (p1 == l1 && p2 != l2) {
            while (p2 != l2)
                sum2 += ar2[p2++];
        } else if (p2 == l2 && p1 != l1) {
            while (p1 != l1)
                sum1 += ar1[p1++];
        }
        maxSum += Math.max(sum1, sum2);
        return maxSum;
    }
}
