package org.example.Leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/number-of-provinces/submissions/
 * asked in Swiggy
 */
public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] aux = new int[n];

        for(int i = 0; i < n; i++)
            aux[i] = i;

        for(int r = 0; r < n; r++){
            for(int c = r + 1; c < n; c++){
                if(isConnected[r][c] == 1){
                    connect(r, c, aux, n);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i : aux) set.add(i);

        return set.size();
    }

    private void connect(int r, int c, int[] aux, int n){
        int rv = aux[r];
        int cv = aux[c];
        for(int i = 0; i < n; i++){
            if(aux[i] == rv) aux[i] = cv;
        }
    }

}
