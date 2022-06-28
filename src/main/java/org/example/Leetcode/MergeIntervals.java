package org.example.Leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/submissions/
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new IntervalComparator());

        List<Integer[]> resultList = new ArrayList<>();
        int ps = intervals[0][0];
        int pe = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int cs = intervals[i][0];
            int ce = intervals[i][1];
            if (cs > pe) {
                // new interval
                resultList.add(new Integer[]{ps, pe});
                ps = cs;
                pe = ce;
            } else {
                if (ce >= pe) {
                    //extended end
                    pe = ce;
                }
            }
        }
        resultList.add(new Integer[]{ps, pe});
        int[][] result = new int[resultList.size()][];
        for(int i = 0; i < resultList.size(); i++)
            result[i] = new int[]{resultList.get(i)[0],resultList.get(i)[1]};
        return result;
    }

    class IntervalComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] i1, int[] i2) {
            return (i1[0] != i2[0]) ? i1[0] - i2[0] : i1[1] - i2[1];
        }
    }
}
