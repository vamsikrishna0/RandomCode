package leetcode.medium;

public class CountBattleships {

    public int countBattleships(char[][] board) {
        int cTotal = 0;
        int cWithNeighbours = 0;
        char bs = 'X';
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == bs) {
                    cTotal++;
                    if((i < rows - 1 && board[i+1][j] == bs) || (j < cols - 1 && board[i][j+1] == bs))
                        cWithNeighbours++;
                }
            }
        }
        return cTotal - cWithNeighbours;
    }
}
