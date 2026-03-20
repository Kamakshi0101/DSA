class HeapElement
{
    int sum;
    int[] indexes;

    public HeapElement(int s,int[] i)
    {
        this.sum=s;
        this.indexes=i;
    }
}
class Solution {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<HeapElement> minheap= new PriorityQueue<>((a,b)->a.sum-b.sum);
        Set<String> visited= new HashSet<>();
        int firstSum=0;
        for(int i=0;i<mat.length;i++)
        {
            firstSum+=mat[i][0];
        }
        int[] inds= new int[mat.length];
        visited.add(Arrays.toString(inds));
        minheap.add(new HeapElement(firstSum,inds));

        int counter=1;
        while(counter<k)
        {
            HeapElement ele= minheap.poll();
            int sum= ele.sum;
            for(int r=0;r<mat.length;r++)
            {
                int[] indices= ele.indexes.clone();
                if(indices[r]+1>= mat[r].length)
                {
                    continue;
                }
                indices[r]=indices[r]+1;
                String pair= Arrays.toString(indices);
                if(!visited.contains(pair))
                {
                    minheap.add(new HeapElement(
                        sum+mat[r][indices[r]]-mat[r][indices[r]-1],
                        indices
                    ));
                    visited.add(pair);
                }
            }
            counter++;
        }
        return minheap.peek().sum;
    }
}