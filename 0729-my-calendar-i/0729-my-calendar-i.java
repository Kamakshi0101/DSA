class MyCalendar {
    Map<Integer,Integer> map;
    public MyCalendar() {
        map= new TreeMap<Integer,Integer>();
    }
    
    public boolean book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime,0)+1);
        map.put(endTime,map.getOrDefault(endTime,0)-1);

        int booking=0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            booking+=entry.getValue();
            if(booking>1)
            {
                map.put(startTime,map.get(startTime)-1);
                map.put(endTime,map.get(endTime)+1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */