class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int temp[] = new int[n];
        for(int i=0;i<n;i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        List<Deque<Integer>> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int gid = 0;
        list.add(new LinkedList<>());
        list.get(gid).offer(temp[0]);
        map.put(temp[0],0);

        for(int i=1;i<n;i++){
            if(temp[i] - list.get(gid).peekLast() > limit){
                gid++;
                list.add(new LinkedList<>());
            }
            list.get(gid).offer(temp[i]);
            map.put(temp[i],gid);
        }

        for(int i=0;i<n;i++){
            int gi = map.get(nums[i]);
            nums[i] = list.get(gi).poll();
        }
        return nums;
    }
}
