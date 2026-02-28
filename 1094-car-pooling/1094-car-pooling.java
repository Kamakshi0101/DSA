class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map= new TreeMap<>();
        int pass=0;

        for(int i=0;i<trips.length;i++)
        {
            map.put(trips[i][1],map.getOrDefault(trips[i][1],0)+trips[i][0]);
            map.put(trips[i][2],map.getOrDefault(trips[i][2],0)-trips[i][0]);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            pass+= entry.getValue();
            if(pass>capacity)
            {
                return false;
            }
        }
        return true;
    }
}