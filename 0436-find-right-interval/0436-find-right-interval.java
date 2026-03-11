class Solution {
    public int[] findRightInterval(int[][] intervals) {
        PriorityQueue<int[]> minheaps= new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<int[]> minheape= new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i=0;i<intervals.length;i++)
        {
            minheaps.add(new int[]{ intervals[i][0],i});
            minheape.add(new int[]{intervals[i][1],i});
        }
        int[] res= new int[intervals.length];
        for(int i=0;i<intervals.length;i++)
        {
            res[i]=-1;
        }
        while(!minheape.isEmpty())
        {
            int[] curr= minheape.poll();
            while(!minheaps.isEmpty() && minheaps.peek()[0]< curr[0])
            {
                minheaps.poll();
            }
            if(minheaps.isEmpty()) return res;
            res[curr[1]]= minheaps.peek()[1];
        }
        return res;
    }
}