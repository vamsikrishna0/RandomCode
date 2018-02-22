package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Vamsi on 1/27/2017.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        int i=0, j=3;
        int RowIndex = 3 * (i / 3);
        int ColIndex = 3 * (i % 3);
        System.out.println((RowIndex + j / 3) +" "+(ColIndex + j % 3));
    }
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;

                // This is to check if there is the same number in same cube.
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                if (board[RowIndex + j / 3][ColIndex + j % 3] != '.' && !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }
}
