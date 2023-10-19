class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        HashMap<Integer,ArrayList<Integer>> edgeMap = new HashMap<>();
        int[] preReqs = new int[n + 1];
        int[] MT = new int[n + 1];
        for(int i = 0; i < relations.length; i++){
            edgeMap.computeIfAbsent(relations[i][0],k ->  new ArrayList<>()).add(relations[i][1]);
            preReqs[relations[i][1]]++;
        }
        int Time = 0;

        Queue<int[]> q = new LinkedList<>();
        for(int i = 1; i < preReqs.length; i++){
            if(preReqs[i] == 0){
                  MT[i] = time[i - 1];
               q.add(new int[] {i, time[i - 1]}); // Starting point;
            }
        }
 
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] xc = q.remove();
               // System.out.println(xc[0] + " " + xc[1]);
                if(edgeMap.get(xc[0]) == null){
                   
                    continue;
                }
                for(int i = 0; i < edgeMap.get(xc[0]).size(); i++){
                   // q.add(new int[] {edgeMap.get(xc[0]).get(i), xc[1] + time[xc[0] - 1] });
                   preReqs[edgeMap.get(xc[0]).get(i)]--;
                     MT[edgeMap.get(xc[0]).get(i)] = Math.max(MT[edgeMap.get(xc[0]).get(i)], xc[1] + time[edgeMap.get(xc[0]).get(i) - 1] );
                     if( preReqs[edgeMap.get(xc[0]).get(i)] == 0){
                         q.add(new int[] {edgeMap.get(xc[0]).get(i), MT[edgeMap.get(xc[0]).get(i)]});
                     }
                }
            }
        }
        for(int j : MT){
           Time = Math.max(j, Time);
        }
        return Time;
    }
}
