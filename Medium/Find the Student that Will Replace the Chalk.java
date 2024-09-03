class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        List<Long> prefix = new ArrayList<>();
        long sum = 0;
        for(int i=0;i<chalk.length;i++){
            sum+=chalk[i];
            if(sum>k)   return i;
            prefix.add(sum);
        }
        long mod = k%sum;
        int r = Collections.binarySearch(prefix,mod);
        if(r>0) return r+1;
        return -r-1;
    }
}
