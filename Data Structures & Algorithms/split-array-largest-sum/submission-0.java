class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt(); 
        int high = nums[0];
        for(int i =1;i<nums.length;i++){
            high += nums[i];
        }

        while(low < high){
            int x = low + (high - low)/2;


            int count = 1;
            int result = 0;
            for(int i=0;i<nums.length;i++){
                if (result + nums[i] > x){
                    count++;
                    result = 0;
                }

                result += nums[i];
            }
    
            if(count <= k){
                high = x;  
            }else{
                low = x+1;
            }
            
        
        }

        return low;
    }
}