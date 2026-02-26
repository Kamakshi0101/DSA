class Solution {
    public int maxFrequency(int[] nums, int k) {
        int max=0;
        long sum=0;
        int i=0,j=0;
        Arrays.sort(nums);
        while(j<nums.length)
        {
            sum+=nums[j];
            while((long)nums[j]*(j-i+1)-sum>k)
            {
                sum-=nums[i];
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}