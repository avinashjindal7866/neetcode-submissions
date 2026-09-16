class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> dp = new HashMap<>();
        return recursion(nums,target,0,0,dp);
    }

    public static int recursion(int[] nums,int target, int i,int sum,HashMap<String, Integer> dp){
        // if(target != sum){
        //     return 0;
        // }

        if (i == nums.length) {
    if (sum == target) {
        return 1;
    }
    return 0;
}

        if(dp.containsKey(i+","+sum)){
            return dp.get(i+","+sum);
        }

        int a = sum+nums[i];
        int b = sum-nums[i];
        // System.out.println(a + " " + b);
        int onePossiblity = recursion(nums,target,i+1,a,dp); 
        int secondPossiblity = recursion(nums,target,i+1,b,dp);
        dp.put(i+","+sum,onePossiblity + secondPossiblity);
        return dp.get(i+","+sum);

    }
}
