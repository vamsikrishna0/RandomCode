package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vamsi on 1/24/2017.
 */
public class NQueens {
    //Incomplete
    public static void main(String[] args) {

    }
    char[][] rows;
    char[] empty;
    final char nope = '.';
    final char queen = 'Q';
    public List<List<String>> solveNQueens(int n) {
        //len = n-1;
        int size = n;
        rows = new char[n][n];
        char[] chars = new char[n];

        for(int i=0; i<n; i++){
            chars[i] = nope;
        }
        empty = chars.clone();
        for(int i=0; i<n; i++){
            if(i != 0)
                chars[i-1] = nope;
            chars[i] = queen;
            rows[i] = chars.clone();
        }

        char[][] board;
        for(int i=0; i<n; i++){
            board = new char[n][n];
            for(int j=0; j<n;j++){
                if(j == i)
                    board[i] = (rows[i]);
                else
                    board[i] = (empty);
            }
//            nQueens(board, n, 0)
        }

        return null;
    }
    char[][] nQueens(char[][] board, int len, int i, int j){
//        if(board == null || )
        return null;
    }

    boolean checkBoard(char[][] board, int i, int j){
        int len = board.length;
        return false;
    }

}
