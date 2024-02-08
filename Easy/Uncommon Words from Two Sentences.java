class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] t1= s1.split(" ");
        String[] t2= s2.split(" ");
        
        List<String> ls= new ArrayList<>();
        HashMap<String, Integer> map1= new HashMap<>();
        HashMap<String, Integer> map2= new HashMap<>();

        for(String s: t1) map1.put(s, map1.getOrDefault(s,0)+1);

        for(String t: t2) map2.put(t, map2.getOrDefault(t,0)+1);

        for(String key: map1.keySet() ){
            if(map1.get(key)==1 && !map2.containsKey(key)) ls.add(key);

        }

        for(String key: map2.keySet()){
            if(map2.get(key)==1 && !map1.containsKey(key)) ls.add(key);
        }

        String[] s= new String[ls.size()];

        for(int i=0;i<s.length;i++){
            s[i]=ls.get(i);

        }
return s;
    }
}
