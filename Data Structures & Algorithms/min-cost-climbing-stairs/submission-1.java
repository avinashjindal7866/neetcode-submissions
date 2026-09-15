class Solution {
    public int minCostClimbingStairs(int[] cost) {
         int[] dp = new int[cost.length];
        return Math.min(climb(0,cost,dp),climb(1,cost,dp));
    }

    public static int climb(int i,int[] cost,int[] dp){
        if(i >= cost.length){
            return 0;
        }

        // if(i == n){
        //     return 1;
        // }

        // if(dp[i] != 0){
        //     return dp[i];
        // }

        if(dp[i] != 0){
            return dp[i];
        }

        int oneStep = climb(i+1,cost,dp);
        int twoStep = climb(i+2,cost,dp);
        return dp[i] = Math.min(oneStep, twoStep) + cost[i];
    }
}
