class Solution {
    
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int res = 1;
        int in = 1;
        int de = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i] == nums[i-1]){
                in = 1;
                de = 1;
            }else if(nums[i] > nums[i-1]){
                in++;
                de = 1;
            }else{
                de++;
                in = 1;
            }
            int curr = Math.max(in,de);
            res = Math.max(res, curr);
        }

        return res;
    }

}