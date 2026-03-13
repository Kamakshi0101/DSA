class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> maxheap= new PriorityQueue<>(Collections.reverseOrder());
        long sum=0;
        if(target.length==1) return target[0]==1;
        for(int i=0;i<target.length;i++)
        {
            maxheap.offer(target[i]);
            sum+=target[i];
        }
        while(true)
        {
            int val= maxheap.poll();
            if(val==1) return true;
            long rest=sum-val;
            int mod= (int)(val%rest);

            if(rest==1) return true;
            if(mod==0) return false;
            if(mod==val) return false;
            maxheap.offer(mod);
            sum=rest+mod;

        }
    }
}