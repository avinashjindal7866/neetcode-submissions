class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        recursion(nums,target,data,0,result,0);
        return result;
    }

    public void recursion(int[] nums,int target,List<Integer> data,int ans,List<List<Integer>> result,int startIndex){
        if(nums.length == 0 || ans > target){
            return;
        }

        if(ans == target){
            result.add(new ArrayList<>(data));
            return;
        }

        for(int i=startIndex;i<nums.length;i++){
                int val = nums[i];
                ans += val;
                if(ans > target){
                    ans = ans - val;
                    continue;
                }
                data.add(val);
                recursion(nums,target,data,ans,result,i);
                ans = ans - val;
                data.remove(data.size() - 1);   
        }

    }
}
