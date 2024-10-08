class Solution {
    // public int minLength(String s) {
    //     Stack<Character> st = new Stack<>();

    //     for(int i=0;i<s.length();i++){
            
    //         char c = s.charAt(i);
    //         if(st.isEmpty()) st.push(c);
    //         else if(c == 'B' && st.peek() == 'A'){
    //             st.pop();
    //         }else if(c == 'D' && st.peek() == 'C'){
    //             st.pop();
    //         }else{
    //             st.push(c);
    //         }
    //     }
    //     return st.size();
    // }

    // Using Read and Write Approach also done the write inplace :)
    public int minLength(String s) {
        char str[] = s.toCharArray();
        int n = str.length;
        int w = 0;
        for(int r=0; r<n; r++){
            if(w==0){
                str[w] = str[r];
                w++;
                continue;
            }else if(str[r] == 'B' && str[w-1] == 'A'){
                w--;
            }else if(str[r] == 'D' && str[w-1] == 'C'){
                w--;
            }else{
                str[w] = str[r];
                w++;
            }
        }
        return w;
    }
}
