class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length - 1 ;
        for(int i=1;i<nums.length;i++){
            int total = nums[i] + nums[i-1];
            nums[i] = total;
        }

        int left = 0;
        for(int i=0;i<nums.length;i++){
            int remaining = nums[n] - nums[i];
            if(left == remaining){
                return i;
            }else{
                left = nums[i];
            }
        }

        return -1;
    }
}