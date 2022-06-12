package org.example.Practice;

/**
 * https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1/
 */
public class MaxSumOfNonAdjacentElements {

    public static void main(String[] args) {
        int maxSum = findMaxSum(new int[]{5, 5, 10, 100, 10, 5}, 6);
        System.out.println(maxSum);
    }

    static int findMaxSum(int arr[], int n) {
        int includingPrevEl = arr[0];
        int excludingPrevEl = 0;
        int excludingCurEl;
        int i;

        for (i = 1; i < n; i++) {
            // Current max excluding i
            excludingCurEl = Math.max(includingPrevEl, excludingPrevEl);

            // Current max including i
            includingPrevEl = excludingPrevEl + arr[i];
            excludingPrevEl = excludingCurEl;
        }

        // Return max of includingPrevEl and excludingPrevEl
        return Math.max(includingPrevEl, excludingPrevEl);
    }


}
