class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int x : gifts) 
            pq.add(x);

        for(int i=0;i<k;i++)
            pq.add((int)Math.floor(Math.sqrt(pq.remove())));
        
        long ans = 0;
        while(!pq.isEmpty())
            ans += pq.remove();

        return ans;
    }
}
