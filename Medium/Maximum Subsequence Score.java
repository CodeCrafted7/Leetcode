import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
 
    class Pair {
        public int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] arrp = new Pair[n];
        

        for (int i = 0; i < n; i++)
            arrp[i] = new Pair(nums1[i], nums2[i]);
        

        Arrays.sort(arrp, (p1, p2) -> -Integer.compare(p1.a, p2.a));
        
  
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.b, p2.b));
        
        long sum = 0;
        

        for (int i = 0; i < k; i++) {
            sum += arrp[i].a;
            pq.add(arrp[i]);
        }
        

        long max = pq.peek().b * sum;
        

        for (int i = k; i < n; i++) {
            if (pq.peek().b < arrp[i].b) {
      
                sum -= (long) pq.remove().a;
                
                int min = arrp[i].b;
                
    
                if (pq.size() > 0)
                    min = Integer.min(pq.peek().b, min);
                
       
                pq.add(arrp[i]);
                
        
                sum += arrp[i].a;
                max = Long.max(max, min * sum);
            }
        }
        
        return max;
    }
}
