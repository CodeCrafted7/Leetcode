class Solution {
    public int numberOfWays(String corridor) {
        char[] list = corridor.toCharArray();
        long res = 1;
        int seat = 0, plant = 0, total = 0;
        for (char cur : list){
            if (cur == 'S'){
                total++;
                if (seat < 2){
                    seat++;
                } else {
                    res = (res*(plant+1))%1000000007;
                    seat = 1;
                    plant = 0;
                }
            } else {
                if (seat == 2){
                    plant++;
                }
            }
        }
        if (total == 0 || total%2 != 0){
            return 0;
        }
        return (int)res;
    }
}
