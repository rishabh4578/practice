package org.example.Leetcode;

/**
 * https://leetcode.com/problems/combination-sum/
 */

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum {

    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        result.stream().forEach(resultItem ->
                System.out.println(resultItem
                        .stream()
                        .map(i -> String.valueOf(i))
                        .collect(Collectors.joining(", ", "[", "]"))));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        csi(candidates, new int[candidates.length], 0, 0, target, result);
        return result;
    }

    private void csi(int[] candidates, int[] freq, int idx, int sum, int target, List<List<Integer>> result) {
        if (idx == candidates.length) {
            if (sum == target) {
                //add list to result
                List<Integer> resultItem = new ArrayList<>();
                for (int i = 0; i < candidates.length; i++) {
                    for (int f = 0; f < freq[i]; f++) {
                        resultItem.add(candidates[i]);
                    }
                }
                result.add(resultItem);
            }
            return;
        }

        int cnt = 0;
        while (sum + (cnt * candidates[idx]) <= target) {
            freq[idx] = cnt;
            csi(candidates, freq, idx + 1, sum + (cnt * candidates[idx]), target, result);
            cnt++;
        }
    }
}
