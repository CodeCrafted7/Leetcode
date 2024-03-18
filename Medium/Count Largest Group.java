class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=1;i<=n;i++){
            int sum=0;
            int temp=i;
            while(temp>0){
                sum+=temp%10;
                temp=temp/10;
            }
            if(h.containsKey(sum)){
                h.replace(sum,h.get(sum)+1);
            }else{
                h.put(sum,1);
            }
        }
        ArrayList<Integer> a = new ArrayList<>(h.keySet());
        Collections.sort(a,(x,y)->h.get(y)-h.get(x));
        int maxval= h.get(a.get(0));
        int count=0;
        for(int i=0;i<a.size();i++){
            if(h.get(a.get(i))==maxval)
                count++;
        }
        return count;

    }
}
