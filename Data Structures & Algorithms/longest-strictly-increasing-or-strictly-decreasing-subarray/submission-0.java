class Solution {
    
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int res = 1;

        for (int i = 0; i < n - 1; i++) {
            int curLen = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == nums[j - 1] || ((nums[i] < nums[i + 1]) != (nums[j - 1] < nums[j]))) {
                    System.out.println(curLen + "break" + i + " " +j);
                    break;
                }
                curLen++;
                System.out.println(curLen + "j" + j);
            }
            res = Math.max(res, curLen);
            System.out.println(res + "i" + i);
        }

        return res;
    }

}