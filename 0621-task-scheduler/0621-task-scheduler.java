class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq= new int[26];
        for(char t:tasks)
        {
            freq[t-'A']++;
        }
        PriorityQueue<Integer> maxheap= new PriorityQueue<>(Collections.reverseOrder());

        for(int f:freq)
        {
            if(f>0) maxheap.add(f);
        }
        int count=0;
        while(!maxheap.isEmpty())
        {
            List<Integer> temp= new ArrayList<>();
            int cycle=n+1;
            int work=0;

            for(int i=0;i<cycle;i++)
            {
                if(!maxheap.isEmpty())
                {
                    int curr=maxheap.poll();
                    if(curr-1>0)
                    {
                        temp.add(curr-1);
                    }
                    work++;
                }
                
            }
            for(int rem:temp)
                {
                    maxheap.add(rem);
                }
                count+=maxheap.isEmpty()?work:cycle;
        }
        return count;
    }
}