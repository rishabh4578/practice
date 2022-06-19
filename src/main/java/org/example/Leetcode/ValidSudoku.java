package org.example.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] blocks = new Set[9];
        Set<Character>[] cols = new Set[9];
        Set<Character>[] rows = new Set[9];
        for (int i = 0; i < 9; i++) {
            blocks[i] = new HashSet<>();
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char item = board[r][c];

                if (item == '.') continue;

                int rp = r / 3; //row partition
                int cp = c / 3; //col partition

                int b = (rp * 3) + cp;

                if (rows[r].contains(item) || cols[c].contains(item) || blocks[b].contains(item)) {
                    System.out.println("r: " + r + ", c: " + c + ", item: " + item);
                    System.out.println(rows[r].contains(item) + " - " + cols[c].contains(item) + " - " + blocks[b].contains(item));
                    return false;
                } else {
                    rows[r].add(item);
                    cols[c].add(item);
                    blocks[b].add(item);
                }

            }
        }

        return true;
    }
}
