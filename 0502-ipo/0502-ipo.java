// class Solution {
//     public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
//         PriorityQueue<Integer> maxheap= new PriorityQueue<>(Collections.reverseOrder());
//         int[][] project= new int[profits.length][2];

//         for(int i=0;i<profits.length;i++)
//         {
//             project[i][0]=capital[i];
//             project[i][1]=profits[i];
//         }
//         Arrays.sort(project,(a,b)->Integer.compare(a[0],b[0]));
//         int i=0;
//         while(k-->0)
//         {
//             while(i< profits.length && project[i][0]<=w)
//             {
//                 maxheap.offer(project[i][1]);
//                 i++;
//             }
//             if(maxheap.isEmpty()) break;

//             w+=maxheap.poll();
//         }
//         return w;
//     }
// }

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < profits.length; i++)
        {
            minCapital.offer(new int[]{capital[i], profits[i]});
        }

        while(k-- > 0)
        {
            while(!minCapital.isEmpty() && minCapital.peek()[0] <= w)
            {
                maxProfit.offer(minCapital.poll()[1]);
            }

            if(maxProfit.isEmpty())
                break;

            w += maxProfit.poll();
        }

        return w;
    }
}