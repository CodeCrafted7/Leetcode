class Solution {
    
    public String plusOne (String str, int index) {
        
        char[] c = str.toCharArray ();
        
        if (c[index] == '9') {
            c[index] = '0';
        }
        else {
            c[index] += 1;
        }
        
        return new String (c);
    }
    
    public String minusOne (String str, int index) {
        
        char[] c = str.toCharArray ();
        
        if (c[index] == '0') {
            c[index] = '9';
        }
        else {
            c[index] -= 1;
        }
        
        return new String (c);
    }
    
    public int openLock(String[] deadends, String target) {
        
        int minimumTurns = -1;
        Set<String> set = new HashSet<> ();
        Queue<String> queue = new LinkedList<> ();
        
        set.add ("0000");
        queue.offer ("0000");
        
        for (String deadend : deadends) {
            if (deadend.equals ("0000")) {
                return -1;
            }
            
            set.add (deadend);
        }
        
        while (!queue.isEmpty ()) {
            ++minimumTurns;
            int size = queue.size ();
            
            while (size-- != 0) {
                String str = queue.poll ();
                if (str.equals (target)) {
                    return minimumTurns;
                }
                
                for (int index = 0; index < 4; index++) {
                    String plus = plusOne (str, index);
                    String minus = minusOne (str, index);
                    
                    if (!set.contains (plus)) {
                        set.add (plus);
                        queue.offer (plus);
                    }
                    if (!set.contains (minus)) {
                        set.add (minus);
                        queue.offer (minus);
                    }
                }
            }
        }
        
        return -1;
    }
}
