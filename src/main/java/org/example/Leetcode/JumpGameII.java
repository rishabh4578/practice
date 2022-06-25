package org.example.Leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/jump-game-ii/submissions/
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int[] aux = new int[nums.length];
        Arrays.fill(aux, -1);
        return ji(nums, 0, aux);
    }

    private int ji(int[] nums, int idx, int[] aux){
        if(idx == nums.length - 1){
            return 0;
        } else if(idx >= nums.length){
            return Integer.MAX_VALUE;
        }

        if(aux[idx] != -1) return aux[idx];

        int min = Integer.MAX_VALUE;
        for(int i = nums[idx]; i >= 1; i--){
            min = Math.min(ji(nums, idx + i, aux), min);
        }
        min += (min == Integer.MAX_VALUE) ? 0 : 1;
        aux[idx] = min;
        return min;
    }
}
