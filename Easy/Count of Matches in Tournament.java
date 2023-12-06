class Solution {
    public int numberOfMatches(int n) {
        int match = 0,unplayed = 0;
        while(n >= 1){
            if(n % 2 == 0){   
                    n/=2;
                    match += n; 
            }
            else{
                if(unplayed == 1){ 
                    n += unplayed; 
                    n/=2;
                    match += n; 
                    unplayed = 0; 
                }
                else{
                    unplayed = 1; 
                    n/=2;
                    match += n; 
                }
            }
        }
        return match;
    }
}
