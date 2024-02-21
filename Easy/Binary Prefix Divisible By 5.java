class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        LinkedList<Boolean> res = new LinkedList<>();
		
        int num = 0;
        for(int value : nums){
            num = (num * 2 + value) % 5;
            res.addLast(num == 0);
        }
		
		return res;
    }
}
