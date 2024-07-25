class Solution {
    public int[] converttoNewSys(int[] mapping, int[] nums){
        int n = nums.length;
        int newsys[] = new int[n];
        for(int j=0;j<n;j++){
            int num = nums[j];
            if(num == 0){
                newsys[j] = mapping[0];
                continue;
            }
            int i=0,res=0;
            while(num>0){
                int d = num %10;
                int nd = mapping[d];
                res = nd*(int)Math.pow(10,i) + res;
                num = num/10;
                i++;
            }
            newsys[j] = res;
        }
        return newsys;
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int newsys[] = converttoNewSys(mapping,nums);
        Integer index[] = new Integer[n];
        for(int i=0;i<n;i++)
            index[i] = i;
        Arrays.sort(index,new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return newsys[a] - newsys[b];
        }
        });
        int i=0;
        int res[] = new int[n];
        for(int ind : index){
            res[i] = nums[ind];
            i++;
        }
        return res;
    }
}
