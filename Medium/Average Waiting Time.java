class Solution {
    public double averageWaitingTime(int[][] customers) {
        int it = 1;
        long tt = 0;
        for(int customer[] : customers)
        {
            if(it<=customer[0])
                it = customer[0] + customer[1];
            else
                it  = it + customer[1];

            tt += (it - customer[0]); 
        }
        double avg = (tt/(double)customers.length);
        return avg;
    }
}
