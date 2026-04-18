class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxheap= new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int i=0;i<k;i++)
        {
            int x=points[i][0], y=points[i][1];
            int dist= x*x+y*y;
            maxheap.add(new int[]{dist,i});
        }
        for(int i=k;i<points.length;i++)
        {
            int nx=points[i][0], ny=points[i][1];
            int ndist= nx*nx+ny*ny;
            if(maxheap.peek()[0]>ndist)
            {
                maxheap.poll();
                maxheap.add(new int[]{ndist,i});
            }
        }
        int[][] res=new int[k][2];
        for(int i=0;i<k;i++)
        {
            int idx=maxheap.poll()[1];
            res[i]=points[idx];
        }
        return res;

    }
}