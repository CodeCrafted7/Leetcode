class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)
        return false;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> i:map.entrySet()){
            pq.add(i.getKey());
        }
        while(!pq.isEmpty()){
            int poll=pq.poll();
            if(map.get(poll)==0)
            continue;
            for(int i=0;i<groupSize;i++){
                if(map.getOrDefault(poll+i,0)==0){
                    return false;                  
                }
                map.put(poll+i,map.get(poll+i)-1);
                if(map.get(poll+i)>0&&!pq.contains(poll+i)){
                    pq.offer(poll+i);
                }
                
            }
        }
        return true;
    }
}
