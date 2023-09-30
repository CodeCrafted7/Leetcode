class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        int b[]= new int[n];
        int c[]= new int[n];
        
        for(int i=0;i<n;i++)
        {
            b[i] = nums[i];
        }
        
        Arrays.sort(b);
        int temp=0;
        
        for(int i=n-1;i>=0;i--)
        {
            c[temp] = b[i];
            temp++;
        }
        
        temp=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==b[i])
                temp++;
        }
        int gemp=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==c[i])
                gemp++;
        }
        if(temp==n || gemp==n)
            return true;
        
        return false;
    }
    
}
