class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack= new Stack<>();
        int[] nge= new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            nge[i]=-1;
        }
        for(int i=0;i<nums.length;i++)
        {
            while(true)
            {
                if(stack.isEmpty())
                {
                    stack.push(i);
                    break;
                }
                int idx= stack.peek();
                if(nums[i]>nums[idx])
                {
                    nge[idx]=nums[i];
                    stack.pop();
                }
                else
                {
                    stack.push(i);
                    break;
                }
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            while(true)
            {
                if(stack.isEmpty())
                {
                    stack.push(i);
                    break;
                }
                int idx= stack.peek();
                if(nums[i]>nums[idx])
                {
                    nge[idx]=nums[i];
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