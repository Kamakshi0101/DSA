class HeapElement
{
    double val;
    int i;
    int j;
    public HeapElement(double v,int _i,int _j)
    {
        this.val= v;
        this.i= _i;
        this.j= _j;
    }
}
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<HeapElement> minheap= new PriorityQueue<>((a,b)->Double.compare(a.val,b.val));
        Set<Pair<Integer,Integer>> visited= new HashSet<>();
        int counter=1;
        minheap.add(new HeapElement(1.0*arr[0]/arr[arr.length-1],0,arr.length-1));
        visited.add(new Pair<Integer,Integer>(0,arr.length-1));

        while(counter<k)
        {
            HeapElement minEle= minheap.poll();
            int i=minEle.i, j=minEle.j;
            if(i+1<j)
            {
                Pair<Integer,Integer> pair= new Pair<Integer,Integer>(i+1,j);
                if(!visited.contains(pair))
                {
                    minheap.add(new HeapElement(
                        1.0*arr[i+1]/arr[j],i+1,j
                    ));
                    visited.add(pair);
                }
            }
            if(i<j-1)
            {
                Pair<Integer,Integer> pair= new Pair<Integer,Integer>(i,j-1);
                if(!visited.contains(pair))
                {
                    minheap.add(new HeapElement(
                        1.0*arr[i]/arr[j-1],i,j-1
                    ));
                    visited.add(pair);
                }
            }
            counter++;
        }
        return new int[]
        {
            arr[minheap.peek().i],
            arr[minheap.peek().j]
        };
    }
}