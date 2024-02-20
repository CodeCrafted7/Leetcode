class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) 
    {
        Arrays.sort(nums);
        int count=0;
        int prev=0;
        for(int i:nums)
        {
            if(i<0)
            {
                if(k>0)
                {
                    count+=Math.abs(i);
                    k--;
                    prev = i;
                }
                else
                {
                    count+=i;
                }
            }
            else if(i==0)
            {
                k=0;
            }
            else
            {
                if(k%2==0)
                {
                    count+=i;
                    k=0;
                }
                else
                {
                    if(prev==0)
                    {
                        count+=(-1*i);
                        k=0;
                    }
                    else
                    {
                        if(prev>i || Math.abs(prev)>i)
                        {
                            count+=(-1*i);
                        }
                        else
                        {
                            count+=prev;
                            count+=(prev + i);
                        }
                        k=0;
                    }
                }
            }
        }
        if(k%2!=0)
        {
            count+=(prev + prev);
        }
        return count;
    }
}
