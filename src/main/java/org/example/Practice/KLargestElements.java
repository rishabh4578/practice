package org.example.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1#
 * asked in Amazon
 */
public class KLargestElements {

    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        ArrayList<Integer> result = kLargest(arr, arr.length, k);
        System.out.println(result.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(", ")));
        result.sort(Comparator.comparing(Integer::byteValue));
        result.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    public static ArrayList<Integer> kLargest(int arr[], int n, int k) {
        if (k > n) return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr)
            pq.add(i);

        ArrayList<Integer> result = new ArrayList<>();
        int cnt = 0;
        while (cnt != k && !pq.isEmpty()) {
            result.add(pq.remove());
            cnt++;
        }
        return result;
    }
}
