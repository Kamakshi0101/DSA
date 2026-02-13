class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack= new Stack<>();
        int[] nge= new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++)
        {
            while(true)
            {
                if(stack.isEmpty())
                {
                    stack.push(i);
                    break;
                }
                int idx= stack.peek();
                if(temperatures[i]>temperatures[idx])
                {
                    nge[idx]= i-idx;
                    stack.pop();
                }
                else
                {
                    stack.push(i);
                    break;
                }
            }
        }
        return nge;
    }
}