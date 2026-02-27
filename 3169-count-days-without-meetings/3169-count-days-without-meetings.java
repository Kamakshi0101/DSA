class Solution {
    public int countDays(int days, int[][] meetings) {
        List<int[]> list= new ArrayList<>();
        int count=0;
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        list.add(meetings[0]);
        count+=(meetings[0][0]-1);
        for(int i=1;i<meetings.length;i++)
        {
            int[] prev= list.get(list.size()-1);
            int[] curr= meetings[i];

            if(curr[0]>prev[1])
            {
                count+=(curr[0]-prev[1]-1);
                list.add(meetings[i]);
            }
            else
            {
                
                    prev[0]=Math.min(prev[0],curr[0]);
                    prev[1]=Math.max(prev[1],curr[1]);
                
            }
        }
        int[] last= list.get(list.size()-1);
        count+=(days-last[1]);
        
        return count;
    }
}