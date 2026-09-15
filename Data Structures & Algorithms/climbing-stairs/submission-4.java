class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        return climb(0,n,dp);
    }

    public static int climb(int i,int n,int[] dp){
        if(i > n){
            return 0;
        }

        if(i == n){
            return 1;
        }

        if(dp[i] != 0){
            return dp[i];
        }

        int oneStep = climb(i+1,n,dp);
        int twoStep = climb(i+2,n,dp);
        return dp[i] = oneStep + twoStep;
    }
}
