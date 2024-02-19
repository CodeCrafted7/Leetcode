class Solution {
    public int numRookCaptures(char[][] board) {
        int count=0;
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(board[i][j]=='R'){
                    int d=j;
                    int u=j;
                    int l=i;
                    int r=i;
                    //down
                    while(++d<8){
                        if(board[i][d]=='p'){
                            count++;
                            break;
                        }else if(board[i][d]=='B'){
                            break;
                        }
                    }
                    //up
                     while(--u>=0){
                        if(board[i][u]=='p'){
                            count++;
                            break;
                        }else if(board[i][u]=='B'){
                            break;
                        }
                    }
                    //left
                      while(++l<8){
                        if(board[l][j]=='p'){
                            count++;
                            break;
                        }else if(board[l][j]=='B'){
                            break;
                        }
                    }
                    //right
                     while(--r>=0){
                        if(board[r][j]=='p'){
                            count++;
                            break;
                        }else if(board[r][j]=='B'){
                            break;
                        }
                    }
                    return count;
                    
                }
        return 0;
    }
}
