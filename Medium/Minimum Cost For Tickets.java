class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int arr[] = new int[days[days.length-1] + 1];
        int j = 0;
        for(int i = 1;i <= days[days.length-1];i++){
            if(i == days[j]){
                arr[i] = Math.min(costs[0] + (i-1 > 0 ? arr[i-1]: 0), Math.min(
                    costs[1] + (i-7 > 0 ? arr[i-7]: 0),
                    costs[2] + (i-30 > 0 ? arr[i-30]: 0)                
                ));
                j++;
            } else{
                
                arr[i] = arr[i-1];
            }
        }
        return arr[days[days.length-1]];
    }
}
