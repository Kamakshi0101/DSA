class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> maxheap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<nums.length;i++)
        {
            maxheap.add(new int[]{nums[i],i});
        }
        int[] res=new int[k];
        List<int[]> list= new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            list.add(maxheap.poll());
        }
        list.sort((a,b)->a[1]-b[1]);
        for(int i=0;i<k;i++)
        {
            res[i]=list.get(i)[0];
        }
        return res;
    }
}