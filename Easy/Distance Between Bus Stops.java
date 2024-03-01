class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int dist = 0;
        int sum = 0;
        
        for(int el : distance) sum += el;
        
        if(destination>start){
            for(int i=start;i<destination;i++) dist += distance[i];
        }
        else{
            for(int i=destination;i<start;i++) dist += distance[i];
        }
        
        int ans = Math.abs(sum - dist);
        
        return Math.min(dist,ans);
    }
}
