class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetFriendat=times[targetFriend][0];
    Arrays.sort(times,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> available= new PriorityQueue<>();
        PriorityQueue<int[]> occupied= new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i=0;i<times.length;i++)
        {
            available.add(i);
        }
        for(int i=0;i<times.length;i++)
        {
            int at=times[i][0];
            while(!occupied.isEmpty())
            {
                if(at>=occupied.peek()[0])
                {
                    int[] chair= occupied.poll();
                    available.add(chair[1]);
                }
                else
                {
                    break;
                }
            }
            int c=available.poll();
            if(targetFriendat==at)
            {
                return c;
            }
            occupied.add(new int[]{times[i][1],c});
        }
        return -1;

    }
}