class Solution {
   public String getHint(String secret, String guess) {
    int a=0,b=0;
    int[] digits=new int[10];
    for(int i=0;i<secret.length();i++){
        if(secret.charAt(i)==guess.charAt(i)) a++;
        else{
            if(++digits[secret.charAt(i)-'0']<=0) b++;
            if(--digits[guess.charAt(i)-'0']>=0) b++;
        }
    }
    return a+"A"+b+"B";
}
}
