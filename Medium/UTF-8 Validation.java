class Solution {
    
    // return byte - 1
    public int Get_Bytes(int val){

        int pos = 1;
        int res = 0;
        
        while(val > 0){
            if((val & 1) == 0){
                res = pos;
            }
            val >>= 1;
            pos++;
        }
        
        return 7 - res;
    }
    
    public boolean validUtf8(int[] data) {
        
        int byt = 0;
        
        for(int i = 0; i < data.length; i++){
            if(byt == 0){
                // if one byte number continue
                if(((data[i] >> 7) & 1) == 0)     continue;
                
                byt = Get_Bytes(data[i]);

                 if(byt >= 4)  return false;
                
                // invaild no return false(10xxxxxx can't be start of any sequence)
                if(byt == 0)    return false;
            }
            else{
                int x = data[i] >> 6;
                
                // if(first two bits are not 10)
                if(x != 2)  return false;
                byt--;
            }
        }
        
        return byt == 0;
    }
}
