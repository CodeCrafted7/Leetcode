class Solution {
    public int numWaterBottles(int numBottles, int numExchange) 
    {
        int maxBottles=0;
        int emptyBottle=0;
        
        if(numBottles<numExchange)
            return numBottles;
        while((numBottles+emptyBottle)>1)
        {
            maxBottles+=numBottles;
            if((numBottles/numExchange) ==0 )
            {
                emptyBottle+=numBottles;
                if(emptyBottle<numExchange)
                {
                    return maxBottles;
                }
                numBottles=emptyBottle/numExchange;
                emptyBottle%=numExchange;
            }
            else
            {
                emptyBottle+=(numBottles%numExchange);
                numBottles=numBottles/numExchange;
            }
        }
        return maxBottles+1;
    }
}
