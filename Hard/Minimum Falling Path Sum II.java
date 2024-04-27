class Solution {
    public static int dp[][] = new int[201][201];
        public int minFallingPathSum(int[][] a) {
        int i,j,n=a.length;

    for(i=0;i<201;i++)
	{
	    for(j=0;j<201;j++)
	    {
	        dp[i][j]=-1;
	    }
	}
      int  sum = func(n-1,a,n);
      return sum;
}
public static int func(int row, int a[][], int last)
{
    int n=a.length;
    if(row==0)
    {
        int minx = 100001;
        for(int i=0;i<n;i++)
        {
            if(i!=last)
            minx = Math.min(minx, a[row][i]);
        }
        return minx;
    }
    
    if(dp[row][last]!=-1) 
    return dp[row][last];
    
    int minx=100001;
    for(int i=0;i<n;i++)
    {
        if(i!=last)
        {
            int sum = a[row][i] + func(row-1,a,i);
            if(sum<minx)
            minx=sum;
        }
    }
    return dp[row][last] = minx;   
}

}
