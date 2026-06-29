class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> ans = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            
            if(ans.containsKey(nums[i])){
                System.out.println(ans.get(nums[i]));
                return true;
            }else{
                ans.put(nums[i], i);
            }
        }
        return false;
    }
}