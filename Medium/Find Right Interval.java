
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] arr = new int[n][3];
        for(int i=0;i<intervals.length;i++){
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
            arr[i][2] = i;
        }
        
        Arrays.sort(arr,(a,b)->{
            return a[0]-b[0];
        });
        
        int[] res = new int[n];
        
        for(int i=0;i<n;i++){
            int idx = arr[i][2];
            int val = binarySearch(arr,arr[i][1]);
            res[idx] = (val == -1) ? -1 : arr[val][2];
        }
        
        return res;
    }
    
    public int binarySearch(int[][] intervals,int ele){
        int si = 0, ei = intervals.length-1;
        int ans = -1;
        while(si <= ei){
            int mid = (si+ei)/2;
            
            if(intervals[mid][0] >= ele){
                ans = mid;
                ei = mid - 1;
            }
            else{
                si = mid + 1;
            }
        }
        return ans;
    }
}
