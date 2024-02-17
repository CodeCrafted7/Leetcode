class Solution {
   public int findLeastNumOfUniqueInts(int[] arr, int k) {
   
         HashMap<Integer, Integer> p = new HashMap<>();
         PriorityQueue<int[]> q= new PriorityQueue<>((a,b)-> a[1]-b[1]);  
        
        for(int i:arr){
            p.put(i,p.getOrDefault(i, 0) + 1);
        }
      
        for(int w:p.keySet()){
            q.offer(new int[]{w,p.get(w)});
        }
       for(int i=0;i<k;i++){
           int a[]=q.poll();
           if(a[1]>1){
               a[1]--;
               q.offer(a);
           
    }
       }
        return q.size();
   
    }
}
