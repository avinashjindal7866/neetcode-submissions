class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        HashMap<String,Boolean> dp = new HashMap<>();
        return recursion(nums, 0, target,dp);
    }

    public static boolean recursion(int[] nums,int i,int target, HashMap<String,Boolean> dp){
        if (target == 0) {
            return true;
        }

        if (i >= nums.length || target < 0) {
            return false;
        }

        if(dp.containsKey(i+","+target)){
            return dp.get(i+","+target);
        }

        boolean take = recursion(nums, i + 1, target - nums[i],dp);

        // Don't take nums[i]
        boolean skip = recursion(nums, i + 1, target,dp);
        dp.put(i+","+target,take || skip);
        return dp.get(i+","+target);
        
    }
    
}
