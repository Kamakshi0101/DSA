class Solution {
    public void backtrack(List<List<Integer>> res, int[] nums, List<Integer> curr)
    {
        if(curr.size()==nums.length)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!curr.contains(nums[i]))
            {
                curr.add(nums[i]);
                backtrack(res,nums,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> curr= new ArrayList<>();

        backtrack(res,nums,curr);

        return res;
    }
}