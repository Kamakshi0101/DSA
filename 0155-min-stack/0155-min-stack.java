class MinStack {
    List<int[]> s;
    public MinStack() {
        s= new ArrayList<>();
    }
    
    public void push(int val) {
        if(s.isEmpty())
        {
            s.add(new int[]{val,val});
        }
        else
        {
            int minval= Math.min(val, s.get(s.size()-1)[1]);
            s.add(new int[]{val,minval});
        }
    }
    
    public void pop() {
        s.remove(s.size()-1);
    }
    
    public int top() {
        return s.get(s.size()-1)[0];
    }
    
    public int getMin() {
        return s.get(s.size()-1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */