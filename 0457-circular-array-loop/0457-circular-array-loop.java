class Solution {

    public int calcNextidx(int[] nums, int curr) {
        int n = nums.length;
        int next = ((curr + nums[curr]) % n + n) % n; 
        return next;
    }

    public boolean circularArrayLoop(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            Set<Integer> set = new HashSet<>();

            boolean isPos = nums[i] > 0;
            int curr = i;

            while (true) {

                int next = calcNextidx(nums, curr);

                
                if (next == curr) break;

                // direction change → invalid
                if (isPos && nums[next] < 0) break;
                if (!isPos && nums[next] > 0) break;

                // cycle found
                if (set.contains(next)) return true;

                set.add(next);
                curr = next;   
            }
        }

        return false;
    }
}
