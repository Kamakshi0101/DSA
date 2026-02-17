class Solution {
    public int findDuplicate(int[] nums) {
        // for(int i=0;i<nums.length;i++)
        // {
        //     int index = Math.abs(nums[i])-1;
        //     if (nums[index] < 0) {
        //         return index + 1;
        //     }
        //     nums[index] = -nums[index];
        // }
        // return 0;

        int slow= nums[0];
        int fast= nums[0];

        do
        {
            slow= nums[slow];
            fast= nums[nums[fast]];
        }
        while(slow!=fast);

        slow=nums[0];
        while(slow!=fast)
        {
            slow=nums[slow];
            fast= nums[fast];
        }
        return slow;
    }
}