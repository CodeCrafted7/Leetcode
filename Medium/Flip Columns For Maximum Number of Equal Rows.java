class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String,Integer> map = new HashMap<>();

        for(int row[]: matrix){
            StringBuilder value = new StringBuilder();
            StringBuilder flipped = new StringBuilder();

            for(int r : row){
                value.append(r);
                flipped.append(1-r);
            }

            String v = value.toString();
            String f = flipped.toString();


            map.put(v,map.getOrDefault(v,0)+1);
            map.put(f,map.getOrDefault(f,0)+1);
        }

        int maxi = Integer.MIN_VALUE;
        for(int x : map.values()){
            maxi = Math.max(maxi,x);
        }
        return maxi;
    }
}
