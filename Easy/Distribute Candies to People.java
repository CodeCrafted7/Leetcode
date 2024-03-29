class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] output = new int[num_people];

        int i=0;
        int loops = 0;
        while(candies > 0){
            if(i == num_people){
                i = 0;
                loops++;
            }

            int currCandy = (loops * num_people) + (i + 1);
            if(candies - currCandy < 0){
                output[i] += candies;
            }else{
                output[i] += currCandy;
            }
            i++;
            candies -= currCandy;
        }
        return output;
    }
}
