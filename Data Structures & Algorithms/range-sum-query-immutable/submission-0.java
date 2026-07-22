class NumArray {
    int[] range;
    public NumArray(int[] nums) {
        range = new int[nums.length];
        range = nums;
        // for(int i=1;i<nums.length;i++){
        //     range[i] = nums[i] + range[i-1];
        // }
        // for(int i=0;i<range.length;i++){
        //     System.out.println(range[i]);
        // }
    }
    
    public int sumRange(int left, int right) {
        int result = 0;
        for(int i=left;i<=right;i++){
            result = result + range[i];
        }
        return result;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */