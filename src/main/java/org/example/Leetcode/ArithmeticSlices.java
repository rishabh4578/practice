package org.example.Leetcode;

/**
 * https://leetcode.com/problems/arithmetic-slices/submissions/
 */
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int cnt = 0;
        Integer diff = null;
        int len = nums.length;
        if(len < 3) return 0;
        for(int i = 0; i <= len - 3; i++){
            for(int j = i + 1; j < len; j++){
                if(diff == null) diff = nums[j] - nums[j - 1];
                else if (nums[j] - nums[j - 1] != diff) {
                    diff = null;
                    break;
                }
                if(j - i >= 2)
                    cnt++;
            }
        }
        return cnt;
    }

}
