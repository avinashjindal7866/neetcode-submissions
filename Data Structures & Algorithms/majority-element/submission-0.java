class Solution {
    public int majorityElement(int[] nums) {
        int m = nums[0];
        int count = 1;

        for(int i = 1; i<nums.length;i++){
            if(m == nums[i]){
                count++;
            }else{
                if(count == 0){
                    m = nums[i];
                    count++;
                }else{
                    count--;
                }
            }
        }
        return m;
    }
}