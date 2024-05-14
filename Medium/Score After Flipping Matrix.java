class Solution {
    public int matrixScore(int[][] grid) {
        
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==0){
                for(int j=0;j<grid[i].length;j++){
                    if(grid[i][j]==0)
                        grid[i][j]=1;
                    else
                        grid[i][j]=0;
                }
            }
        }

        int zcount;
        int ocount;
        for(int i=0;i<grid[0].length;i++){
            zcount=0;
            ocount=0;
            for(int j=0;j<grid.length;j++){
                if(grid[j][i]==0)
                    zcount++;
                else
                    ocount++;
            }
            if(zcount>ocount){
                for(int j=0;j<grid.length;j++){
                    if(grid[j][i]==0)
                        grid[j][i]=1;
                    else
                        grid[j][i]=0;
                }
            }
        }

        int count=0;
        for(int i=0;i<grid.length;i++){
            count+=countvalue(grid[i]);
        }

        return count;
    }

    public int countvalue(int[] num){
        int count=0;
        for(int i=num.length-1,j=0;i>=0;i--,j++){
            if(num[i]==1)
                count+=Math.pow(2,j);
        }
        return count;
    }
}
