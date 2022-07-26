package org.example.Leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/combinations/submissions/
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        ci(n,1,k,new ArrayList<Integer>(), result);
        return result;
    }

    private void ci(int n, int i, int k, List<Integer> curList, List<List<Integer>> result){
        if(curList.size() == k){
            result.add(new ArrayList<>(curList));
            return;
        }

        if(i == n + 1 || n - i + 1 < k - curList.size()) return;

        //i skipped
        ci(n, i + 1, k, curList, result);

        //i taken
        curList.add(i);
        ci(n, i + 1, k, curList, result);
        curList.remove(curList.size() - 1);
    }
}
