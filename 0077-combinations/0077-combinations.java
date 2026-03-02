class Solution {
    public void backtrack(int f,int n,int k,List<List<Integer>> res, List<Integer> l)
    {
        if(l.size()==k)
        {
            res.add(new ArrayList<>(l));
            return;
        }
        for(int i=f;i<=n;i++)
        {
            l.add(i);
            backtrack(i+1,n,k,res,l);
            l.remove(l.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> l= new ArrayList<>();
        backtrack(1,n,k,res,l);
        return res;
    }
}