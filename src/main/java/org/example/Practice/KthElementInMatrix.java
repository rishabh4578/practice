package org.example.Practice;

/**
 * https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1#
 * asked in Amazon
 */

import java.util.PriorityQueue;

public class KthElementInMatrix {
    public static int kthSmallest(int[][]mat,int n,int k)
    {
        //code here.
        int lim = k > n ? n : k; //only optimization that passed all test cases

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int r = 0; r < lim; r++){
            for(int c = 0; c < lim; c++){
                pq.add(mat[r][c]);
            }
        }
        int rslt = pq.peek();
        for(int i = 0; i < k; i++)
            rslt = pq.remove();

        return rslt;
    }
}
