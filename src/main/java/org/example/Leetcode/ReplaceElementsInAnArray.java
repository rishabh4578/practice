package org.example.Leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/replace-elements-in-an-array/submissions/
 */
public class ReplaceElementsInAnArray {
    public int[] arrayChange(int[] nums, int[][] operations) {
        if (operations == null || operations.length == 0) return nums;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for (int[] op : operations) {
            int idx = map.get(op[0]);
            map.remove(op[0]);
            nums[idx] = op[1];
            map.put(op[1], idx);
        }

        return nums;
    }
}
