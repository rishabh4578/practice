package org.example.DSAOneCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * place N queens on an n * n chess board such that they don't kill each other
 * https://www.youtube.com/watch?v=MHXR4PCY8c0&list=PLUcsbZa0qzu3yNzzAxgvSgRobdUUJvz7p&index=11
 */
public class NQueenProblem {
    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> nQueenCoordinates = placeNQueens(n);
        System.out.println(nQueenCoordinates.stream()
                .map(coordinates -> String.format("(%s, %s)", coordinates.get(0), coordinates.get(1)))
                .collect(Collectors.joining(", ")));
    }

    private static List<List<Integer>> placeNQueens(int n) {
        List<List<Integer>> filled = new ArrayList<>();
        placeNQueensInternal(n, filled);
        return filled;
    }

    private static boolean placeNQueensInternal(int n, List<List<Integer>> filled) {
        if (filled.size() == n) return true;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (canBePlaced(filled, r, c)) {
                    List<Integer> currCoordinates = new ArrayList<>();
                    currCoordinates.add(r);
                    currCoordinates.add(c);
                    filled.add(currCoordinates);
                    boolean result = placeNQueensInternal(n, filled);
                    if (result) return true;
                    filled.remove(currCoordinates);
                }
            }
        }
        return false;
    }

    private static boolean canBePlaced(List<List<Integer>> filled, int r, int c) {
        for (List<Integer> filledCoordinates : filled) {
            int fR = filledCoordinates.get(0);
            int fC = filledCoordinates.get(1);
            if (r == fR || c == fC || Math.abs(fR - r) == Math.abs(fC - c))
                return false;
        }
        return true;
    }
}
