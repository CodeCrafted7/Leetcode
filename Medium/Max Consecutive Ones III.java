class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        int start = 0;
        int ans = 0;
        
        for(int i = 0 ; i< nums.length; i++){
            if(nums[i] == 0 ){
                q.add(i);
                count++;
            }

            if(count>k ){
                start = q.remove()+1;
                count--;
            }

            ans = Math.max(ans , i-start+1);
        }

        return ans;
    }
}
