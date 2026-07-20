class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int count = nums[0];
        for (int i = 1; i < n; i++) {
            if(nums[i] > nums[i-1]){
                count = count + nums[i];
            }else{
                count = nums[i];
            }
            res = Math.max(res, count);
        }

        return res;
    }
}