package org.example.Practice;

import java.util.Stack;

/**
 * https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1
 * asked in Amazon
 */
public class LargestRectangularAreaInHistogram {

    public static void main(String[] args) {
        long[] arr = {9l, 10l, 4l, 10l, 4l, 5l, 16l};
        System.out.println(getMaxArea(arr, arr.length));
    }

    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) {
        int ni = (int) n;
        // your code here
        if (hist == null || n == 0) return 0;
        if (n == 1) return hist[0];

        //find previous smaller element for every element in one pass
        int[] prevSmaller = new int[ni];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        prevSmaller[0] = -1;

        for (int i = 1; i < ni; i++) {
            while (!stack.isEmpty() && hist[stack.peek()] >= hist[i])
                stack.pop();

            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        //find next smaller element and maxArea by every element in one pass
        Stack<Integer> stack2 = new Stack<>();
        long maxArea = 0L;
        stack2.push(ni - 1);

        for (int i = ni - 1; i >= 0; i--) {
            int nextSmaller = ni;
            if (i < n - 1) {
                while (!stack2.isEmpty() && hist[stack2.peek()] >= hist[i])
                    stack2.pop();

                nextSmaller = stack2.isEmpty() ? ni : stack2.peek();

                stack2.push(i);
            }

//            System.out.println("i: " + i + ", ps: " + prevSmaller[i] + ", ns: " + nextSmaller);
            long area = (nextSmaller - prevSmaller[i] - 1) * hist[i];
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }


}
