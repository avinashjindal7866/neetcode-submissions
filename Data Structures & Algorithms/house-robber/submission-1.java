class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        return houseRob(nums,0,dp);
    }

    public static int houseRob(int[] nums,int i,int[] dp){
        if(i >= nums.length){
            return 0;
        }

        if(dp[i] != 0){
            return dp[i];
        }

        int first = nums[i] + houseRob(nums,i+2,dp);
        int second = houseRob(nums,i+1,dp);
        return dp[i] = Math.max(first,second);
    }
}
