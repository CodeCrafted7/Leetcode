class Solution {    

    int rects[][];
    double [] rectsProb;

    public Solution(int[][] rects) {
        this.rects=rects;
        long totalArea = 0;
        long [] areas= new long[rects.length];

        for (int i=0;i<rects.length;i++){
            areas[i] = ((long)(rects[i][2]-rects[i][0]+1))*(rects[i][3]-rects[i][1]+1);
            totalArea += areas[i];
        }

        rectsProb= new double[rects.length];
        for (int i=0;i<rects.length;i++)
            rectsProb[i] = (0.0+areas[i])/totalArea;
    }
    
    public int[] pick() {
        Random r = new Random();
        double rectChooseByProb = r.nextDouble();
        int rectChoosen =-1;
        for (int i=0;i<rects.length;i++){ 
            rectChooseByProb -= rectsProb[i]; 
            if (rectChooseByProb<=0.000001) {
                rectChoosen=i;
                break;
            }
        } 
        int x = rects[rectChoosen][2] - rects[rectChoosen][0] + 1;
        int y = rects[rectChoosen][3] - rects[rectChoosen][1] + 1 ;
        int xRand = r.nextInt(x), yRand= r.nextInt(y);
        return new int[]{xRand + rects[rectChoosen][0], yRand + rects[rectChoosen][1]};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
