class Solution {
    public int binarysearch(int items[][],int q){
        int l = 0;
        int r = items.length -1;
        int maxi = 0;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(items[mid][0] > q){
                r = mid-1;
            }
            else{
                maxi = Math.max(maxi,items[mid][1]);
                l = mid + 1;
            }
        }
        return maxi;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int m = queries.length;
        int result[] = new int[m];
        Arrays.sort(items, (a,b) -> Integer.compare(a[0],b[0]));
        int maxseenbeauty = items[0][1];

        for(int i=0;i<n;i++){
            maxseenbeauty = Math.max(maxseenbeauty,items[i][1]);
            items[i][1] = maxseenbeauty;
        }

        for(int i=0; i<m; i++){
            int q = queries[i];
            result[i] = binarysearch(items,q); 
        }
        return result;
    }
}
