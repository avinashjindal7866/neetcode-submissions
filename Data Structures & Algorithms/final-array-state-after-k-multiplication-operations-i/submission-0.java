class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }

        for(int i=1;i<=k;i++){
            int val = pq.poll();
            int fi = val * multiplier;
            int index = checkElement(nums,val);
            pq.add(fi);
            nums[index] = fi;
            System.out.println(index+" " + fi);
        }
        
        return nums;
    }

    public static int checkElement(int[] nums,int val){
        for(int i=0;i<nums.length;i++){
            if(val == nums[i]){
                return i;
            }
        }

        return -1;
    }
}