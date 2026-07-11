class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        int result = 0;
        while(start <= end ){
            if(nums[start] != val){
                start++;
                result++;
            }else{
                if(nums[end] == val){
                    end--;
                }else{
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                    end--;
                    // result ++;
                }
            }
        }
        return result;
    }
}