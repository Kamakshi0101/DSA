class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        
        int[] ans= new int[n];
        for(int id=n-1;id>=0;id--)
        {
            if(Math.abs(nums[left])> Math.abs(nums[right]))
            {
                ans[id]=nums[left]*nums[left];
                left++;
            }
            else
            {
                ans[id]=nums[right]*nums[right];
                right--;
            }
        }
        return ans;
    }
}