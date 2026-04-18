class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> minheap= new PriorityQueue<>((a,b)->{
            if(a.length()==b.length())
            {
                return a.compareTo(b);
            }
            return a.length()-b.length();
        });
        for(int i=0;i<nums.length;i++)
        {
            minheap.add(nums[i]);
            if(minheap.size()>k)
            {
                minheap.poll();
            }
        }
        return minheap.peek();
    }
}