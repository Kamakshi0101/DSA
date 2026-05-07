class Solution {
    private int solve(int i, int n, int[] cost, int[] dp) {
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        return dp[i] = cost[i] + Math.min(solve(i+1, n, cost, dp), solve(i+2, n, cost, dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        // int n = cost.length;
        // int[] dp = new int[n + 2];
        // for(int i=n-1; i>=0; i--) {
        //     dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        // }
        // return Math.min(dp[0], dp[1]);
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        solve(0, n, cost, dp);
        return Math.min(dp[0], dp[1]);
    }
}