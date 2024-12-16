class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0],a[0]));

        for(int []i:classes){
            int p = i[0] , t = i[1];
            pq.offer(new double[]{Gain(p,t) , p , t});
        }

        while(extraStudents-->0){
            double[]top = pq.poll();
            double avg = top[0];
            int p = (int)top[1] , t = (int)top[2];
            pq.offer(new double[]{Gain(p + 1 , t + 1) , p + 1, t + 1});
        }
        double sum = 0;
        for(double i[] : pq){
            sum+=i[1]/i[2];
        }
        return sum/classes.length;


    }
    double Gain(int p , int t){
        return (double)(p + 1)/ (t + 1) - (double)p/t;
    }
}
