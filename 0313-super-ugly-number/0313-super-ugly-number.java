class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<int[]> minheap= new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<primes.length;i++)
        {
            minheap.add(new int[]{
                primes[i],0,primes[i]
            });
        }
        int[] ugly= new int[n];
        ugly[0]=1;
        for(int i=1;i<n;i++)
        {
            int[] main= minheap.poll();
            int val1= main[0];
            int index1=main[1];
            int prime1=main[2];

            ugly[i]=val1;
            while(!minheap.isEmpty() && minheap.peek()[0]==val1)
            {
                int[] ele= minheap.poll();
                int val2=ele[0], index2=ele[1], prime2=ele[2];
                minheap.add(new int[]{
                    prime2*ugly[index2+1],
                    index2+1,prime2
                });
            }
            minheap.add(new int[]{
                prime1*ugly[index1+1],
                index1+1,
                prime1
            });
        }
        return ugly[n-1];
    }
}