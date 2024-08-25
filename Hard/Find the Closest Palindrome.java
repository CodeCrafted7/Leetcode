class Solution {
    public long FindNearrestPalindrome(long fh,boolean isodd){
        long res = fh;
        if(isodd){
            fh/=10;
        }
        while(fh>0){
            res  = res * 10 + (fh % 10);
            fh/=10;
        }
        return res;
    }
    public String nearestPalindromic(String n) {
        ArrayList<Long> list = new ArrayList<>();
        int len = n.length();
        int mid = (len%2==0)?(len/2):(len/2+1);
        boolean isodd = (len%2!=0);
        long Fh = Long.parseLong(n.substring(0,mid));
        list.add(FindNearrestPalindrome(Fh,isodd));
        list.add(FindNearrestPalindrome(Fh+1,isodd));
        list.add(FindNearrestPalindrome(Fh-1,isodd));
        list.add((long)Math.pow(10,len-1)-1);
        list.add((long)Math.pow(10,len)+1);
        long num = Long.parseLong(n);
        long mindiff = Long.MAX_VALUE;
        long res = Long.MAX_VALUE;
        for(long el : list){
            if(el == num)
                continue;
            long currdiff = Math.abs(el-num);
            if(currdiff<mindiff){
                res = el;
                mindiff = currdiff;
            }else if(currdiff == mindiff){
                res = Math.min(el,res);
            }
        }
        return String.valueOf(res);
    }
}
