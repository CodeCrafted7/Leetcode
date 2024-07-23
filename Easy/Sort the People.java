class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        Integer run[] = new Integer[n];
        for(Integer i=0;i<n;i++)
            run[i] = i;
        Arrays.sort(run, new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return heights[b] - heights[a];
            }
        });
        int i=0;
        String res[] = new String[n];
        for(Integer ind : run){
            res[i] = names[ind];
            i++;
        }
        return res;
    }
}
