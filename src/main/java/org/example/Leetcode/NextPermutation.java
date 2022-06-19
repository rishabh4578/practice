package org.example.Leetcode;

/**
 * asked in MakeMyTrip
 * https://leetcode.com/problems/next-permutation/submissions/
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null) return;

        boolean nextFound = false;
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int swapIdx = len - 1;
                while (nums[swapIdx] <= nums[i] && swapIdx >= i) {
                    swapIdx--;
                }
                if (swapIdx == i) break;
                swap(nums, i, swapIdx);
                for (int k = i + 1; k <= (len - 1 + i + 1) / 2; k++)
                    swap(nums, k, len - k + i);
                nextFound = true;
                break;
            }
        }

        if (!nextFound) {
            for (int i = 0; i <= (len - 1) / 2; i++) {
                swap(nums, i, len - 1 - i);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
