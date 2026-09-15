class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        // Don't rob last house
        int first = houseRob(nums, 0, nums.length - 2, dp1);

        // Don't rob first house
        int second = houseRob(nums, 1, nums.length - 1, dp2);

        return Math.max(first, second);
    }

    public static int houseRob(int[] nums, int i, int j, int[] dp) {

        if (i > j) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int first = nums[i] + houseRob(nums, i + 2, j, dp);

        int second = houseRob(nums, i + 1, j, dp);

        return dp[i] = Math.max(first, second);
    }
}