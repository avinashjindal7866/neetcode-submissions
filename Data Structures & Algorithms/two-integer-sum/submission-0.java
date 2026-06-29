class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> ans = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer output = target - nums[i];
            if(ans.containsKey(output)){
                System.out.println(output);
                return new int[]{ans.get(output), i};
            }
            ans.put(nums[i], i); 
        }
        return new int[]{};
    }
}
