class Solution {
    public String tictactoe(int[][] moves) {
        int n = moves.length;
        char [][] board = new char [3][3];
        for(int i = 0; i < n; i++)
        {
            if(i%2 == 0){
                board[ moves[i][0] ][ moves[i][1] ] = 'X';
                if(isWin(board,'X'))
                    return "A";
                else
                    if(i == 8)
                        return "Draw";
            }
            else{
                board[ moves[i][0] ][ moves[i][1] ] = 'O';
                if(isWin(board,'O'))
                    return "B";             
            }
        }
        return "Pending";
        
    }

    private boolean isWin(char[][]board, char player){
        if( (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][2] == player) ||
            (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][2] == player) ||
            (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][2] == player) ||
            (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[2][0] == player) ||
            (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[2][1] == player) ||
            (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[2][2] == player) ||
            (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == player) ||
            (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == player)  )
            return true;
        else 
            return false;
    }
}
