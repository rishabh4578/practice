package org.example.DSAOneCourse;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] arr = {2, 10, 60, 30, 5, 40};
        int k = 3;
        int kthLargestElement = getKthLargestElement(arr, k);
        System.out.println(kthLargestElement);
    }

    private static int getKthLargestElement(int[] arr, int k) {
        if (arr == null || k > arr.length) return -1;

        //for min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++)
            pq.add(arr[i]);

        int idx = k;
        while (idx < arr.length) {
            if (arr[idx] > pq.peek()) {
                pq.poll();
                pq.add(arr[idx]);
            }
            idx++;
        }
        return pq.peek();
    }

}
