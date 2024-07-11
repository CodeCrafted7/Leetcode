class Solution {
    public int minOperations(String[] logs) {
        int d=0;
        for(String log : logs)
        {
            if(log.equals("./")) continue;
            else if(log.equals("../")){
                d--;
                if(d<0) d=0;
            }
            else d++;
        }
        return d;
    }
}
