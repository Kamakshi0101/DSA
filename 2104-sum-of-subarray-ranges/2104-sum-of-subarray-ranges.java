class Solution {
    public long subArrayRanges(int[] nums) {
        int[] nse= new int[nums.length];
        int[] pse= new int[nums.length];
        int[] nge= new int[nums.length];
        int[] pge= new int[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            nse[i]=nums.length;
            pse[i]=-1;
            nge[i]=nums.length;
            pge[i]=-1;
        }
        Stack<Integer> stack = new Stack<>();
        //nse
        for(int i=0;i<nums.length;i++)
        {
            while(true){
            if(stack.isEmpty())
            {
                stack.push(i);
                break;
            }
            int idx= stack.peek();
            if(nums[i]<=nums[idx])
            {
                nse[idx]=i;
                stack.pop();
            }
            else
            {
                stack.push(i);
                break;
            }}
        }
        stack.clear();
        //pse
        for(int i=nums.length-1;i>=0;i--)
        {
            while(true)
            {
                if(stack.isEmpty())
                {
                    stack.push(i);
                    break;
                }
                int idx= stack.peek();
                if(nums[i]<nums[idx])
                {
                    pse[idx]=i;
                    stack.pop();
                }
                else
                {
                    stack.push(i);
                    break;
                }
            }
        }
        stack.clear();
        //nge
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
                if(nums[i]>=nums[idx])
                {
                    nge[idx]=i;
                    stack.pop();
                }
                else
                {
                    stack.push(i);
                    break;
                }
            }
        }
        stack.clear();
        //pge
        for(int i=nums.length-1;i>=0;i--)
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
                    pge[idx]=i;
                    stack.pop();
                }
                else
                {
                    stack.push(i);
                    break;
                }
            }
        }
        long res=0;
        for(int i=0;i<nums.length;i++)
        {
            long minc= (long)(i-pse[i]) * (nse[i]-i) *nums[i];
            long maxc= (long)(i-pge[i])*(nge[i]-i)*nums[i];

            res= res+(maxc-minc);
        }
        return res;
        
    }
}