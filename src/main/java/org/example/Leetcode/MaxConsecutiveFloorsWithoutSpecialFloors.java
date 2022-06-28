package org.example.Leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/submissions/
 */
public class MaxConsecutiveFloorsWithoutSpecialFloors {
    public int maxConsecutive(int bottom, int top, int[] special) {

        if (special.length == 0) return bottom - top + 1;

        Arrays.sort(special);

        int maxConsecutiveFloors = Integer.MIN_VALUE;
        for (int i = 0; i < special.length; i++) {
            int currBP = special[i];
            int prevBP;
            if (i == 0) {
                prevBP = bottom;
            } else {
                prevBP = special[i - 1];
            }
            if (currBP == prevBP) continue;
            int currMaxConsecutiveFloors = currBP - prevBP - 1;
            if (i == 0) currMaxConsecutiveFloors += 1;
            maxConsecutiveFloors = Math.max(currMaxConsecutiveFloors, maxConsecutiveFloors);
        }
        maxConsecutiveFloors = Math.max(maxConsecutiveFloors, top - special[special.length - 1]);
        return maxConsecutiveFloors;
    }
}
