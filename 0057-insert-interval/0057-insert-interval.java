class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res= new ArrayList<>();
        int i=0;
        while(i<intervals.length && newInterval[0]>intervals[i][1])
        {
            res.add(intervals[i]);
            i++;
        }
        while(i<intervals.length && (intervals[i][1]>= newInterval[0] && intervals[i][0]<= newInterval[1]))
        {
            newInterval[0]= Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]= Math.max(intervals[i][1],newInterval[1]);
            i++; 
        }
        res.add(newInterval);
        while(i<intervals.length)
        {
            res.add(intervals[i]);
            i++;
        }
        int[][] r= new int[res.size()][2];
        for(int k=0;k<res.size();k++)
        {
            r[k]=res.get(k);
        }
        return r;
    }
}