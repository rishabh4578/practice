package org.example.DSAOneCourse;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 2, 7, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted: " + Arrays.stream(arr).mapToObj(n -> String.valueOf(n)).collect(Collectors.joining(", ")));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotIdx = low;
        int i = low, j = high;
        while (i < j) {
            while (arr[i] <= arr[pivotIdx]) i++;
            while (arr[j] > arr[pivotIdx]) j--;
            if (i < j) //take care at this point
                swap(arr, i, j);
        }
        swap(arr, pivotIdx, j);
        return j;
    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

}
