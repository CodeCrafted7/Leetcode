class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(isDividing(i)){
                list.add(i);
            }
        }
            return list;
            
    }
            public static boolean isDividing(int n1){
            if(n1<=0)
            return false;
            int n=n1;
            while(n1!=0){
                int ans=0;
                ans=n1%10;
                if(ans==0||n%ans!=0){
               return false;
                }
                n1/=10;
            }
        
        return true;
    }
}
