class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum=0;
        int dup=0;
        Map<Integer,Integer> map= new HashMap<>();
        long max= 0;
        for(int i=0;i<k;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],0);
            }
            map.put(nums[i],map.get(nums[i])+1);
            sum+=nums[i];
            if(map.get(nums[i])>1)
            {
                dup++;
            }
            
        }
        if(dup==0)
            {
                max=Math.max(max,sum);
            }
        for(int i=k;i<nums.length;i++)
        {
            int add= nums[i];
            int remove= nums[i-k];

            if(!map.containsKey(add))
            {
                map.put(add,0);
            }
            map.put(add,map.get(add)+1);
            if(map.get(add)>1) dup++;
            sum+=add;
            if(map.get(remove)>1) dup--;
            map.put(remove,map.get(remove)-1);
            sum-=remove;
            if(dup==0)
            {
                max=Math.max(max,sum);
            }
        }
        return max;
    }
}