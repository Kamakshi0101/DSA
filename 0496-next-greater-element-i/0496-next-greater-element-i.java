class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge= new int[nums1.length];
        Stack<Integer> stack= new Stack<>();

        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums2.length;i++)
        {
            while(true)
            {
                if(stack.isEmpty())
                {
                    stack.push(i);
                    break;
                }
                int idx= stack.peek();
                if(nums2[i]>nums2[idx])
                {
                    map.put(nums2[idx],nums2[i]);
                    stack.pop();
                }
                else
                {
                    stack.push(i);
                    break;
                }
            }
        }
        for(int i=0;i<nums1.length;i++)
        {
            if(map.containsKey(nums1[i]))
            {
                nge[i]=map.get(nums1[i]);
            }
            else
            {
                nge[i]=-1;
            }
        }
        return nge;
    }
}