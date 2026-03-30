class KthLargest {
    PriorityQueue<Integer> minheap;
    int kth;
    public KthLargest(int k, int[] nums) {
        minheap= new PriorityQueue<>();
        kth=k;

        for(int i=0;i<nums.length;i++)
        {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(minheap.isEmpty())
        {
            minheap.add(val);
            return minheap.peek();
        }
        if(minheap.size()<kth)
        {
            minheap.add(val);
            return minheap.peek();
        }
        if(minheap.peek()<val)
        {
            minheap.poll();
            minheap.add(val);
        }
        return minheap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */