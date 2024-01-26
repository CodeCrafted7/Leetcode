class Solution {
    public boolean isOneBitCharacter(int[] b) {
        int k=b.length;
        if(k==1)
            return true;
        int c=0,i;
        for(i=1;i<k;i++)
        {
            if(b[i-1]==1&&(b[i]==0||b[i]==1))
            {
                c=1;
                i++;
            }
            else
                c=0;
        }
        return i>k&&c==1 ? false : true;
    }
}
