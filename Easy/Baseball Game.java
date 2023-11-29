class Solution {
    public int calPoints(String[] op) {
       int[] l = new int[op.length];
        
        int j=0;
        int o=0;
        for(int i=0;i<op.length;i++)
        {
            
            if(op[i].equals("C"))
            {
                l[j-1] = 0;
                j--;           
            }
            else if(op[i].equals("D"))
            {
                l[j] = 2*l[j-1];
                j++;
            }
            else if(op[i].equals("+"))
            {
                l[j] = l[j-1]+l[j-2];
                j++;
            }
            
            else
            {
                l[j] = (Integer.parseInt(op[i]));
                j++;
            }
        }
        
        for(int n=0;n<l.length;n++)
        {
            o+=l[n];
        }
        
       return o;
    }
}
