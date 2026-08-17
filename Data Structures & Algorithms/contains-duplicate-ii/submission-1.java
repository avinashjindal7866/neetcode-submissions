class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int si = 0;

        for(int i=0;i<nums.length;i++){
            si = i + 1;
            while(si > i && si <= nums.length-1){
                // System.out.println(nums[i]+ " " + nums[si]);
                if(nums[i] == nums[si] && Math.abs(i - si) <= k){
                    return true;
                }
                si++;
            }
        }

        return false;
    }
}