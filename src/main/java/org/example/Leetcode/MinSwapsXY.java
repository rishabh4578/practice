package org.example.Leetcode;

/**
 * https://www.youtube.com/watch?v=iplciPpgL2A
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/submissions/
 */
public class MinSwapsXY {

    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length())
            return -1;
        int xy = 0;
        int yx = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') xy++;
            else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') yx++;
        }
        int minSwaps = 0;
        minSwaps += xy / 2 + yx / 2;
        if (xy % 2 != yx % 2) return -1;
        else if (xy % 2 == 1) minSwaps += 2;
        return minSwaps;
    }

}
