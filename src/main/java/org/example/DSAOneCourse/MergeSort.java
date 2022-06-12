package org.example.DSAOneCourse;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 2, 7, 8, 1};
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println("Sorted: " + Arrays.stream(arr).mapToObj(n -> String.valueOf(n)).collect(Collectors.joining(", ")));
    }

    private static void mergeSort(int[] arr, int low, int high, int[] helper) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid, helper);
            mergeSort(arr, mid + 1, high, helper);
            merge(arr, low, mid, high, helper);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high, int[] helper) {
        for (int i = low; i <= high; i++)
            helper[i] = arr[i];

        int helperLeft = low;
        int helperRight = mid + 1;
        int cur = low;

        while (helperLeft <= mid && helperRight <= high) {
            if (helper[helperLeft] < helper[helperRight])
                arr[cur++] = helper[helperLeft++];
            else arr[cur++] = helper[helperRight++];
        }

        //copy remaining elements
        while (helperLeft <= mid)
            arr[cur++] = helper[helperLeft++];
        while (helperRight <= high)
            arr[cur++] = helper[helperRight++];
    }

}
