class Solution {
    public boolean canBeEqual(int[] a, int[] b) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for(int k : a)
            map1.put(k,map1.getOrDefault(k,0)+1);
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int k : b)
            map2.put(k,map2.getOrDefault(k,0)+1);
        for(int k : map1.keySet()){
            if(!map2.containsKey(k))
                return false;
            if(map1.get(k) != map2.get(k))
                return false;
        }
        return true;
    }
}
