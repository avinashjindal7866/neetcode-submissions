class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int minCount = Integer.MAX_VALUE;
        int si = 0;
        int ei = si + k - 1;

        while(ei < nums.length){
            int val = nums[ei] - nums[si];
            minCount = Math.min(minCount,val);
            System.out.println(minCount + " " + val);
            si++;
            ei = si + k - 1;
        }

        return minCount;
    }
}