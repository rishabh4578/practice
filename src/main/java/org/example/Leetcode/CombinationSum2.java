package org.example.Leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/combination-sum-ii/submissions/
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        result.stream().forEach(resultItem ->
                System.out.println(resultItem
                        .stream()
                        .map(i -> String.valueOf(i))
                        .collect(Collectors.joining(", ", "[", "]"))));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int c : candidates)
            freq.put(c, (freq.containsKey(c)) ? freq.get(c) + 1 : 1);

        int[] unqCandidates = new int[freq.keySet().size()];
        int idx = 0;
        for (int key : freq.keySet())
            unqCandidates[idx++] = key;

        Map<Integer, Integer> used = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        csi2(unqCandidates, 0, freq, used, 0, target, result);
        return result;
    }

    private boolean csi2(int[] unqCandidates, int idx, Map<Integer, Integer> freq, Map<Integer, Integer> used, int sum,
                         int target, List<List<Integer>> result) {
        if (sum > target) return false;
        if (idx == unqCandidates.length || sum == target) {
            if (sum == target) {
                List<Integer> resultItem = new ArrayList<>();
                for (Map.Entry<Integer, Integer> usedCandidate : used.entrySet()) {
                    for (int f = 0; f < usedCandidate.getValue(); f++) {
                        resultItem.add(usedCandidate.getKey());
                    }
                }
                result.add(resultItem);
            }
            return true;
        }

        int key = unqCandidates[idx];
        int maxFreq = freq.get(key);
        boolean continueFurther;
        for (int j = 0; j <= maxFreq; j++) {
            used.put(key, j);
            continueFurther = csi2(unqCandidates, idx + 1, freq, used, sum + (j * key), target, result);
            if (!continueFurther) break;
        }
        used.remove(key);
        return true;
    }

}
