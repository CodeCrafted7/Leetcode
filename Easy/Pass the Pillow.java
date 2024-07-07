class Solution {
    public int passThePillow(int n, int time) {
        int ct=0;
        boolean revdir = false;
        int perpos=1;
        while(ct<time)
        {
            if(!revdir)
                perpos+=1;
            else
                perpos-=1;
            if(perpos==1 || perpos==n)
                revdir = !revdir;
            ct++;
        }
        return perpos;
    }
}
