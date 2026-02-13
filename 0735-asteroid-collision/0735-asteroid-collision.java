class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<asteroids.length;i++)
        {
            int curr= asteroids[i];
            while(true)
            {
                if(stack.isEmpty())
                {
                    stack.push(i);
                    break;
                }
                if(curr>=0)
                {
                    stack.push(i);
                    break;
                }
                int idx= stack.peek();
                if(asteroids[idx]>=0)
                {
                    int abscurr= Math.abs(curr);
                    if(asteroids[idx]>abscurr)
                    {
                        break;
                    }
                    else if(asteroids[idx]==abscurr)
                    {
                        stack.pop();
                        break;
                    }
                    else
                    {
                        stack.pop();
                    }
                }
                else
                {
                    stack.push(i);
                    break;
                }
            }
        }
        int[] res= new int[stack.size()];
        int i=res.length-1;
        while(!stack.isEmpty())
        {
            res[i]= asteroids[stack.pop()];
            i--;
        }
        return res;
        
    }
}