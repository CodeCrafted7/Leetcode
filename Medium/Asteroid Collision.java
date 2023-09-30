class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<asteroids.length;i++)
        {
            if(s.isEmpty()|| asteroids[i]>0)
            {
                s.push(asteroids[i]);
            }
            else
            {
                while(!s.isEmpty())
                {
                    int t = s.peek();
                    if(t<0)
                    {
                        s.push(asteroids[i]);
                        break;
                    }
                    
                    int mv = Math.abs(asteroids[i]);
                    if(mv==t)
                    {
                        s.pop();
                        break;
                    }
                    else if(mv<t)
                    {
                        break;
                    }
                    else{
                        s.pop();
                        if(s.isEmpty())
                        {
                            s.push(asteroids[i]);
                            break;
                        }
                    }
                    
                }
            }
        }
        int ans[] = new int[s.size()];
        for(int i=s.size()-1;i>=0;i--)
        {
            ans[i] = s.pop();
        }
        return ans;
    }
}
