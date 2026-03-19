class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minheap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        Set<Pair<Integer,Integer>> visited= new HashSet<>();

        minheap.add(new int[]
        {
            nums1[0]+nums2[0],0,0
        });
        int counter=1;
        List<List<Integer>> res= new ArrayList<>();
        while(counter<=k)
        {
            int[] ele=minheap.poll();
            int sum=ele[0];
            int i=ele[1], j=ele[2];

            res.add(Arrays.asList(nums1[i],nums2[j]));

            if(i+1<nums1.length)
            {
                Pair<Integer,Integer> pair= new Pair<Integer,Integer>(i+1,j);
                if(!visited.contains(pair))
                {
                    minheap.add(new int[]{
                        nums1[i+1]+nums2[j],i+1,j
                    });
                }
                visited.add(pair);
            }
            if(j+1<nums2.length)
            {
                Pair<Integer,Integer> pair= new Pair<Integer,Integer>(i,j+1);
                if(!visited.contains(pair))
                {
                    minheap.add(new int[]{
                        nums1[i]+nums2[j+1],i,j+1
                    });
                }
                visited.add(pair);
            }
            counter++;
        }
        return res;
    }
}